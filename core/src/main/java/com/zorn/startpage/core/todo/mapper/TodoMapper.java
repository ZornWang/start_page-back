package com.zorn.startpage.core.todo.mapper;

import com.zorn.startpage.core.todo.entity.Todo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:13
 */
@Mapper
public interface TodoMapper extends BaseMapper<Todo> {

}
