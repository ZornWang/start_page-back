package com.zorn.startpage.core.webgroup.controller;

import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.webgroup.entity.Webgroup;
import com.zorn.startpage.core.webgroup.service.WebgroupService;
import com.zorn.startpage.core.website.dto.CreateWebsiteDTO;
import com.zorn.startpage.core.website.dto.UpdateWebsiteDTO;
import com.zorn.startpage.core.website.entity.Website;
import com.zorn.startpage.core.website.service.WebsiteService;
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

    @Autowired
    private WebsiteService websiteService;

    //    获取所有组
    @GetMapping
    public List<Webgroup> findAll(@ModelAttribute("user") User user) {
        return webgroupService.list(WrapperUtils.getQueryWrapper("user_id", user.getId()));
    }

    //    创建组
    @PostMapping
    public Boolean create(@ModelAttribute("user") User user) {
        return webgroupService.save(Webgroup.createByUserId(user.getId()));
    }

    //    删除组
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Integer groupId) {
        return webgroupService.removeById(groupId);
    }

    //    查询组内所有
    @GetMapping("/{id}")
    public List<Website> findGroupWebsites(@PathVariable("id") Integer groupId) {
        return websiteService.list(WrapperUtils.getQueryWrapper("group_id", groupId));
    }

    //    创建组内网站
    @PostMapping("/{id}")
    public Boolean createGroupWebsites(@PathVariable("id") Integer groupId, @RequestBody CreateWebsiteDTO createWebsiteDTO) {
        return websiteService.save(Website.create(createWebsiteDTO.setGroupId(groupId)));
    }

    //    删除组内网站
    @DeleteMapping("/{id}")
    public Boolean removeGroupWebsites(@PathVariable("id") Integer groupId, @RequestBody UpdateWebsiteDTO updateWebsiteDTO) {
        return websiteService.removeById(updateWebsiteDTO.getId());
    }
}

