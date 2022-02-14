package com.zorn.startpage.core.webgroupWebsite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 11:57:09
 */
@Getter
@Setter
@TableName("webgroup_website")
public class WebgroupWebsite {

    /**
     * group_web_id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * group_id
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * website_id
     */
    @TableField("website_id")
    private Integer websiteId;


}
