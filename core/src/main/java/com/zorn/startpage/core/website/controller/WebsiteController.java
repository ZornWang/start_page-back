package com.zorn.startpage.core.website.controller;


import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.website.dto.CreateWebsiteDTO;
import com.zorn.startpage.core.website.dto.UpdateWebsiteDTO;
import com.zorn.startpage.core.website.entity.Website;
import com.zorn.startpage.core.website.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-15 12:07:22
 */
@RestController
@RequestMapping("/website")
public class WebsiteController {
    @Autowired
    private WebsiteService websiteService;

    //    创建网站
    @PostMapping
    public Boolean create(@RequestBody CreateWebsiteDTO createWebsiteDTO) {
        return websiteService.save(Website.create(createWebsiteDTO));
    }

    //    删除网站
    @DeleteMapping
    public Boolean remove(@RequestBody UpdateWebsiteDTO updateWebsiteDTO) {
        return websiteService.removeById(updateWebsiteDTO.getId());
    }

    //    更新网站信息
    @PutMapping
    public Boolean update(@RequestBody UpdateWebsiteDTO updateWebsiteDTO) {
        return websiteService.updateById(Website.update(updateWebsiteDTO));
    }

    //    获取单个网站信息
    @GetMapping
    public Website findOne(Integer id) {
        return websiteService.getById(id);
    }
}

