package com.zorn.startpage.core.webgroup.controller;


import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.webgroup.entity.Webgroup;
import com.zorn.startpage.core.webgroup.service.WebgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 11:56:44
 */
@RestController
@RequestMapping("/webgroup")
public class WebgroupController {
    @Autowired
    private WebgroupService webgroupService;

    @GetMapping
    public List<Webgroup> findAll(@ModelAttribute("user") User user) {
        return webgroupService.list(WrapperUtils.getQueryWrapper("user_id", user.getId()));
    }

    @PostMapping
    public Boolean create(@ModelAttribute("user") User user) {
        return webgroupService.save(Webgroup.createByUserId(user.getId()));
    }

    @DeleteMapping
    public Boolean remove(@RequestBody Webgroup webgroup) {
        return webgroupService.removeById(webgroup);
    }
}

