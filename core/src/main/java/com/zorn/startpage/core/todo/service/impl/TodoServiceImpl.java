package com.zorn.startpage.core.todo.service.impl;

import com.zorn.startpage.core.todo.entity.Todo;
import com.zorn.startpage.core.todo.mapper.TodoMapper;
import com.zorn.startpage.core.todo.service.TodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:13
 */
@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {

}
