package com.zorn.startpage.core.background.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

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

    public Background(String url, Integer userId) {
        this.url = url;
        this.userId = userId;
    }
}
