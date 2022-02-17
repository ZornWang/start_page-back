package com.zorn.startpage.core.memo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.core.memo.dto.CreateMemoDTO;
import com.zorn.startpage.core.memo.dto.UpdateMemoDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author wzh
 * @since 2022-02-17 12:42:26
 */
@Getter
@Setter
@TableName("memo")
public class Memo {

    /**
     * 备忘录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 备忘录内容
     */
    @TableField("content")
    private String content;

    /**
     * 用户id
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
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    public static Memo createMemoById(User user, CreateMemoDTO createMemoDTO) {
        Memo memo = new Memo();
        memo.setUserId(Objects.requireNonNull(user.getId(), ResultStatus.PARAM_IS_NULL.getMessage()));
        memo.setContent(Objects.requireNonNull(createMemoDTO.getContent(), ResultStatus.PARAM_IS_NULL.getMessage()));
        return memo;
    }

    public static Memo update(Integer id, UpdateMemoDTO updateMemoDTO) {
        Memo memo = new Memo();
        memo.setId(Objects.requireNonNull(id, ResultStatus.PARAM_IS_NULL.getMessage()));
        memo.setContent(Objects.requireNonNull(updateMemoDTO.getContent(), ResultStatus.PARAM_IS_NULL.getMessage()));
        return memo;
    }
}
