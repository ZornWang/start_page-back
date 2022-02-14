package com.zorn.startpage.auth.user.controller;

import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.mapper.UserMapper;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取User对象
     *
     * @param data：储存user对象
     * @param request：HttpServletRequest
     */
    @ModelAttribute
    public void getModel(Map<String, Object> data, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        if (user != null) {
            User selectOne = userMapper.selectOne(WrapperUtils.getQueryWrapper("username", user.getUsername()));
            data.put("user", selectOne);
        }
    }
}
