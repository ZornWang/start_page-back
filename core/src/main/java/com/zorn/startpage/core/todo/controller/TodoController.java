package com.zorn.startpage.core.todo.controller;


import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.utils.WrapperUtils;
import com.zorn.startpage.core.todo.dto.CreateTodoDTO;
import com.zorn.startpage.core.todo.dto.UpdateTodoDTO;
import com.zorn.startpage.core.todo.entity.Todo;
import com.zorn.startpage.core.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:13
 */
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> findAll(@ModelAttribute("user") User user) {
        return todoService.list(WrapperUtils.getQueryWrapper("user_id", user.getId()));
    }

    @PostMapping
    public Boolean create(@ModelAttribute("user") User user,@RequestBody CreateTodoDTO createTodoDTO) {
        return todoService.save(Todo.createByUserId(user.getId(),createTodoDTO.getContent()));
    }

    @DeleteMapping
    public Boolean remove(@RequestBody UpdateTodoDTO updateTodoDTO) {
        return todoService.removeById(updateTodoDTO.getId());
    }

    @PutMapping("/{id}/done")
    public Boolean done(@PathVariable("id") Integer id) {
        return todoService.updateById(Todo.done(id));
    }

    @PutMapping("/{id}/reback")
    public Boolean reback(@PathVariable("id") Integer id) {
        return todoService.updateById(Todo.reback(id));
    }

    @PutMapping("/{id}/update")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody UpdateTodoDTO updateTodoDTO) {
        return todoService.updateById(Todo.update(id, updateTodoDTO.getContent()));
    }

}

