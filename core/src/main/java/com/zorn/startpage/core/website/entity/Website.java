package com.zorn.startpage.core.website.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 09:17:48
 */
@Getter
@Setter
@TableName("website")
public class Website {

    /**
     * website_id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * website_url
     */
    @TableField("url")
    private String url;

    /**
     * group_id
     */
    @TableField("group_id")
    private Integer groupId;

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


}
