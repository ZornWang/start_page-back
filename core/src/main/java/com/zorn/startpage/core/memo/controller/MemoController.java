package com.zorn.startpage.core.memo.controller;


import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.memo.dto.CreateMemoDTO;
import com.zorn.startpage.core.memo.dto.UpdateMemoDTO;
import com.zorn.startpage.core.memo.entity.Memo;
import com.zorn.startpage.core.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-17 12:42:26
 */
@RestController
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    private MemoService memoService;

    @GetMapping
    public List<Memo> findAll(@ModelAttribute("user") User user) {
        return memoService.list(WrapperUtils.getQueryWrapper("user_id", user.getId()));
    }

    @PostMapping
    public Boolean create(@ModelAttribute("user") User user, @RequestBody CreateMemoDTO createMemoDTO) {
        return memoService.save(Memo.createMemoById(user, createMemoDTO));
    }

    @DeleteMapping
    public Boolean remove(@RequestBody UpdateMemoDTO updateMemoDTO) {
        return memoService.removeById(updateMemoDTO.getId());
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody UpdateMemoDTO updateMemoDTO) {
        return memoService.updateById(Memo.update(id, updateMemoDTO));
    }

    @GetMapping("/{id}")
    public Memo findOne(@PathVariable("id") Integer id) {
        return memoService.getById(id);
    }
}

