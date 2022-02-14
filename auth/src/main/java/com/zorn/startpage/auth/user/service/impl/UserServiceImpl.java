package com.zorn.startpage.auth.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.zorn.startpage.auth.user.dto.CreateUserDTO;
import com.zorn.startpage.auth.user.dto.LoginDTO;
import com.zorn.startpage.auth.user.dto.UpdateUserDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.mapper.UserMapper;
import com.zorn.startpage.auth.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zorn.startpage.auth.user.utils.JwtService;
import com.zorn.startpage.auth.user.vo.UserTokenVO;
import com.zorn.startpage.base.enums.COSUrl;
import com.zorn.startpage.base.enums.RedisHeader;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.enums.TemplateId;
import com.zorn.startpage.base.exception.GlobalException;
import com.zorn.startpage.base.result.Result;
import com.zorn.startpage.base.utils.TXUtil;
import com.zorn.startpage.base.utils.WrapperUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 04:26:42
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TXUtil txUtil;

    @Override
    public Boolean register(CreateUserDTO createUserDTO) {
        String rightCode = stringRedisTemplate.opsForValue().get(RedisHeader.REGISTER_CODE.getHeader() + createUserDTO.getPhone());
        if (rightCode == null) {
            //为获取验证码或已过期
            throw new GlobalException(ResultStatus.CODE_NOT_EXIST.getMessage(), ResultStatus.CODE_NOT_EXIST.getCode());
        }
        if (createUserDTO.getCode() == null || !createUserDTO.getCode().equals(rightCode)) {
            //验证码输入错误
            throw new GlobalException("验证码错误", ResultStatus.CODE_IS_ERROR.getCode());
        }
        User userByPhone = userMapper.selectOne(WrapperUtils.getQueryWrapper("phone", createUserDTO.getPhone()));
        if (userByPhone != null) {
            //用户已存在
            throw new GlobalException("该用户已存在", ResultStatus.USER_IS_EXIST.getCode());
        }
        User user = createUserDTO.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
        stringRedisTemplate.delete(RedisHeader.REGISTER_CODE.getHeader() + user.getPhone());
        return true;
    }

    @Override
    public Boolean getRegisterCode(String phone) throws TencentCloudSDKException {
        //获取验证码
//            String code = "111111";
        String code = getCode();
        String templateId = TemplateId.REGISTER.getValue();

        SendSmsResponse rep = txUtil.sendSMS(Objects.requireNonNull(phone, "传入手机号不能为空"), code, templateId);

//            System.out.println(SendSmsResponse.toJsonString(rep));

        JSONObject jsonObject = JSON.parseObject(SendSmsResponse.toJsonString(rep));
        String code1 = jsonObject.getString("SendStatusSet");
        JSONObject object = JSON.parseObject(code1.substring(1, code1.length() - 1));
        String backcode = object.getString("Code");

        if (backcode.equals("Ok")) {
            stringRedisTemplate.opsForValue().set(RedisHeader.REGISTER_CODE.getHeader() + phone, code);
            stringRedisTemplate.expire(RedisHeader.REGISTER_CODE.getHeader() + phone, 5, TimeUnit.MINUTES);
        } else {
            throw new GlobalException(ResultStatus.GET_CODE_ERROR.getMessage(), ResultStatus.GET_CODE_ERROR.getCode());
        }
        return true;
    }

    public String getCode() {
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(code);
    }

    @Override
    public Boolean forgetPassword(UpdateUserDTO updateUserDTO) {
        String rightCode = stringRedisTemplate.opsForValue().get(RedisHeader.RETRIEVE_PASSWORD_CODE.getHeader() + updateUserDTO.getPhone());
        if (rightCode == null) {
            //为获取验证码或已过期
            throw new GlobalException(ResultStatus.CODE_NOT_EXIST.getMessage(), ResultStatus.CODE_NOT_EXIST.getCode());
        }
        if (updateUserDTO.getCode() == null || !updateUserDTO.getCode().equals(rightCode)) {
            //验证码输入错误
            throw new GlobalException(ResultStatus.CODE_IS_ERROR.getMessage(), ResultStatus.CODE_IS_ERROR.getCode());
        }

        User userByPhone = userMapper.selectOne(WrapperUtils.getQueryWrapper("phone", updateUserDTO.getPhone()));
        if (userByPhone == null) {
            //用户不存在
            throw new GlobalException(ResultStatus.USER_NOT_EXIST.getMessage(), ResultStatus.USER_NOT_EXIST.getCode());
        }
        User user = updateUserDTO.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        updateById(user);
        stringRedisTemplate.delete(RedisHeader.RETRIEVE_PASSWORD_CODE.getHeader() + user.getPhone());
        return true;
    }

    @Override
    public Boolean getForgetCode(String phone) throws TencentCloudSDKException {
        //获取验证码
//            String code = "111111";
        String code = getCode();
        String templateId = TemplateId.FORGET_PASSWORD.getValue();

        SendSmsResponse rep = txUtil.sendSMS(Objects.requireNonNull(phone, "传入手机号不能为空"), code, templateId);

//            System.out.println(SendSmsResponse.toJsonString(rep));

        JSONObject jsonObject = JSON.parseObject(SendSmsResponse.toJsonString(rep));
        String code1 = jsonObject.getString("SendStatusSet");
        JSONObject object = JSON.parseObject(code1.substring(1, code1.length() - 1));
        String backcode = object.getString("Code");

        if (backcode.equals("Ok")) {
            stringRedisTemplate.opsForValue().set(RedisHeader.RETRIEVE_PASSWORD_CODE.getHeader() + phone, code);
            stringRedisTemplate.expire(RedisHeader.RETRIEVE_PASSWORD_CODE.getHeader() + phone, 5, TimeUnit.MINUTES);
        } else {
            throw new GlobalException(ResultStatus.GET_CODE_ERROR.getMessage(), ResultStatus.GET_CODE_ERROR.getCode());
        }
        return true;
    }

    @Override
    public String uploadAvatar(String username, MultipartFile file) {
        String fileName = username + "_avatar_" + System.currentTimeMillis();
        return txUtil.uploadfile(Objects.requireNonNull(file, ResultStatus.FILE_IS_NULL.getMessage()), COSUrl.USERAVATAR.getUrl(), fileName);
    }

    @Override
    public void updateUser(UpdateUserDTO updateUserDTO) {

    }
}
