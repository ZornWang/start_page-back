package com.zorn.startpage.core.todo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zorn.startpage.base.enums.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:13
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("todo")
public class Todo {

    /**
     * toDoList_id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 是否完成（1:完成，0:未完成）
     */
    @TableField("done")
    private Integer done;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * user_id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createAt;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    public static Todo createByUserId(Integer userId,String content) {
        Todo todo = new Todo();
        todo.setUserId(Objects.requireNonNull(userId,ResultStatus.PARAM_IS_NULL.getMessage()));
        todo.setDone(0);
        todo.setContent(Objects.requireNonNull(content,ResultStatus.PARAM_IS_NULL.getMessage()));
        return todo;
    }

    public static Todo done(Integer id) {
        Todo todo = new Todo();
        todo.setId(Objects.requireNonNull(id, ResultStatus.PARAM_IS_NULL.getMessage()));
        todo.setDone(1);
        return todo;
    }

    public static Todo reback(Integer id) {
        Todo todo = new Todo();
        todo.setId(Objects.requireNonNull(id, ResultStatus.PARAM_IS_NULL.getMessage()));
        todo.setDone(0);
        return todo;
    }

    public static Todo update(Integer id, String content) {
        Todo todo = new Todo();
        todo.setId(Objects.requireNonNull(id, ResultStatus.PARAM_IS_NULL.getMessage()));
        todo.setContent(Objects.requireNonNull(content,ResultStatus.PARAM_IS_NULL.getMessage()));
        return todo;
    }
}
