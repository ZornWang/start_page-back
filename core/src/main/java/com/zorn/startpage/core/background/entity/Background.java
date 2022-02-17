package com.zorn.startpage.core.background.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:18:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("background")
public class Background {

    /**
     * 背景图id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 背景图url
     */
    @TableField("url")
    private String url;

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
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    public Background(String url, Integer userId) {
        this.url = url;
        this.userId = userId;
    }
}
