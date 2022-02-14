package com.zorn.startpage.core.background.controller;

import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.background.entity.Background;
import com.zorn.startpage.core.background.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:50
 */
@RestController
@RequestMapping("/background")
public class BackgroundController {
    @Autowired
    private BackgroundService backgroundService;

    @GetMapping
    public List<Background> findAll(@ModelAttribute("user") User user) {
        return backgroundService.list(WrapperUtils.getQueryWrapper("user_id",user.getId()));
    }

    @GetMapping("/{id}")
    public Background findOne(@PathVariable("id") Integer id) {
        return backgroundService.getById(id);
    }

    @PostMapping
    public Boolean create(@RequestParam String url, @ModelAttribute("user") User user) {
        return backgroundService.save(new Background(url, user.getId()));
    }

    @PutMapping
    public Boolean update(@RequestBody Background background) {
        return backgroundService.updateById(background);
    }

    @DeleteMapping
    public Boolean remove(@RequestBody Background background) {
        return backgroundService.removeById(background);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file, @ModelAttribute("user") User user) {
        return backgroundService.uploadBackground(user.getUsername(), file);
    }
}

