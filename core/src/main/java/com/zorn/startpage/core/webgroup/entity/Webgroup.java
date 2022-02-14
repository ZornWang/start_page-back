package com.zorn.startpage.core.webgroup.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2022-02-14 11:56:44
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("webgroup")
public class Webgroup {

    /**
     * group_id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user_id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 收藏夹名
     */
    @TableField("name")
    private String name;

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

    public Webgroup(Integer id) {
        this.id = id;
    }

    public static Webgroup createByUserId(Integer userId) {
        Webgroup webgroup = new Webgroup();
        webgroup.setUserId(userId);
        return webgroup;
    }
}
