package com.zorn.startpage.auth.user.service;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.zorn.startpage.auth.user.dto.CreateUserDTO;
import com.zorn.startpage.auth.user.dto.LoginDTO;
import com.zorn.startpage.auth.user.dto.UpdateUserDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zorn.startpage.auth.user.vo.UserTokenVO;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 04:26:42
 */
public interface UserService extends IService<User> {

    Boolean register(CreateUserDTO createUserDTO);

    Boolean getRegisterCode(String phone) throws TencentCloudSDKException;

    Boolean forgetPassword(UpdateUserDTO updateUserDTO);

    Boolean getForgetCode(String phone) throws TencentCloudSDKException;

    String uploadAvatar(String username, MultipartFile file);
}
