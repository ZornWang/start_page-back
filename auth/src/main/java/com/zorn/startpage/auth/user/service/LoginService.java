package com.zorn.startpage.auth.user.service;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.zorn.startpage.auth.user.dto.CreateUserDTO;
import com.zorn.startpage.auth.user.dto.LoginDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.vo.UserTokenVO;

import javax.validation.constraints.NotNull;

public interface LoginService {

    UserTokenVO login(LoginDTO loginDTO);


    UserTokenVO refresh(@NotNull(message = "refreshToken不能为空") String refreshToken);

    Boolean logout(User user);
}
