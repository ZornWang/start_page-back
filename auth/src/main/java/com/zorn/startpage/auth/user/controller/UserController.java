package com.zorn.startpage.auth.user.controller;


import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.zorn.startpage.auth.user.dto.CreateUserDTO;
import com.zorn.startpage.auth.user.dto.UpdateUserDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.service.UserService;
import com.zorn.startpage.base.annotation.UnLogin;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 04:26:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //    用户注册
    @PostMapping("/register")
    @UnLogin
    public Boolean register(@RequestBody CreateUserDTO createUserDTO) {
        return userService.register(createUserDTO);
    }

    //    获取注册验证码
    @GetMapping("/register/getCode")
    @UnLogin
    public Boolean getCode(String phone) throws TencentCloudSDKException {
        return userService.getRegisterCode(phone);
    }

    //    获取找回密码验证码
    @GetMapping("/forget/getCode")
    public Boolean getForgetCode(String phone) throws TencentCloudSDKException {
        return userService.getForgetCode(phone);
    }

    //    找回密码
    @PostMapping("/forget")
    public Boolean forget(@RequestBody UpdateUserDTO updateUserDTO, @ModelAttribute("user") User user) {
        return userService.forgetPassword(updateUserDTO.setId(user.getId()));
    }

    //    上传头像
    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@ModelAttribute("user") User user, @RequestParam(value = "file") MultipartFile file) {
        return userService.uploadAvatar(user.getUsername(), file);
    }

    //    更新用户信息
    @PutMapping
    public Boolean update(@RequestBody UpdateUserDTO updateUserDTO, @ModelAttribute("user") User user) {
        return userService.updateById(new User(updateUserDTO.setId(user.getId())));
    }

}

