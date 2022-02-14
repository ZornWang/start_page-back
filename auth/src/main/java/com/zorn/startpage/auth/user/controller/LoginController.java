package com.zorn.startpage.auth.user.controller;

import com.zorn.startpage.auth.user.dto.LoginDTO;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.service.LoginService;
import com.zorn.startpage.auth.user.vo.UserTokenVO;
import com.zorn.startpage.base.annotation.UnLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //    登录
    @UnLogin
    @PostMapping
    public UserTokenVO login(@Validated(User.insert.class) @RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    //    刷新token
    @UnLogin
    @GetMapping("/{refreshToken}")
    public UserTokenVO refresh(@PathVariable("refreshToken") String refreshToken) {
        return loginService.refresh(refreshToken);
    }

    //    获取当前登陆用户
    @GetMapping
    public User account(@ModelAttribute("user") User user) {
        return user;
    }

    //    退出登陆
    @DeleteMapping
    public Boolean logout(@ModelAttribute("user") User user) {
        return loginService.logout(user);
    }
}
