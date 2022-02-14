package com.zorn.startpage.auth.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.zorn.startpage.auth.user.dto.CreateUserDTO;
import com.zorn.startpage.auth.user.dto.LoginDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.mapper.UserMapper;
import com.zorn.startpage.auth.user.service.LoginService;
import com.zorn.startpage.auth.user.utils.JwtService;
import com.zorn.startpage.auth.user.vo.UserTokenVO;
import com.zorn.startpage.base.enums.RedisHeader;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.enums.TemplateId;
import com.zorn.startpage.base.exception.GlobalException;
import com.zorn.startpage.base.utils.TXUtil;
import com.zorn.startpage.base.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UserTokenVO login(LoginDTO loginDTO) {
        User loginUser = Objects.requireNonNull(userMapper.selectOne(WrapperUtils.getQueryWrapper("username", loginDTO.getUsername())), ResultStatus.USER_NOT_EXIST.getMessage());
        //判断密码是否正确
        if (!passwordEncoder.matches(loginDTO.getPassword(), loginUser.getPassword())) {
            throw new GlobalException(ResultStatus.PASSWORD_IS_ERROR.getMessage(), ResultStatus.PASSWORD_IS_ERROR.getCode());
        }
        //检查该用户是否在登录时间段内
        String token_exit = stringRedisTemplate.opsForValue().get(RedisHeader.USER_TOKEN.getHeader() + loginUser.getUsername());
        if (token_exit != null) {
            String refreshToken_exit = stringRedisTemplate.opsForValue().get(RedisHeader.USER_REFRESH_TOKEN.getHeader() + loginUser.getUsername());
            return new UserTokenVO(token_exit, refreshToken_exit, loginUser);
        }
        String accessToken = jwtService.getAccessToken(loginUser);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_TOKEN.getHeader() + loginUser.getUsername(), accessToken);
        stringRedisTemplate.expire(RedisHeader.USER_TOKEN.getHeader() + loginUser.getUsername(), 15, TimeUnit.DAYS);
        String refreshToken = jwtService.getRefreshToken(loginUser);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_REFRESH_TOKEN.getHeader() + loginUser.getUsername(), refreshToken);
        stringRedisTemplate.expire(RedisHeader.USER_REFRESH_TOKEN.getHeader() + loginUser.getUsername(), 30, TimeUnit.DAYS);
        return new UserTokenVO(accessToken, refreshToken, loginUser);

    }

    @Override
    public UserTokenVO refresh(String refreshToken) {
        User user = jwtService.getUser(Objects.requireNonNull(refreshToken, ResultStatus.TOKEN_NOT_PROVIDE.getMessage()));

        stringRedisTemplate.delete(RedisHeader.USER_TOKEN.getHeader() + user.getUsername());
        stringRedisTemplate.delete(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getUsername());

        String newAccessToken = jwtService.getAccessToken(user);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_TOKEN.getHeader() + user.getUsername(), newAccessToken);
        stringRedisTemplate.expire(RedisHeader.USER_TOKEN.getHeader() + user.getUsername(), 15, TimeUnit.DAYS);
        String newRefreshToken = jwtService.getRefreshToken(user);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getUsername(), newRefreshToken);
        stringRedisTemplate.expire(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getUsername(), 30, TimeUnit.DAYS);
        return new UserTokenVO(newAccessToken, newRefreshToken, user);
    }

    @Override
    public Boolean logout(User user) {
        stringRedisTemplate.delete(RedisHeader.USER_TOKEN.getHeader() + user.getUsername());
        stringRedisTemplate.delete(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getUsername());
        stringRedisTemplate.delete(RedisHeader.REGISTER_CODE.getHeader() + user.getUsername());
        return true;
    }
}
