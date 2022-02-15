package com.zorn.startpage.core.website.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.core.website.dto.CreateWebsiteDTO;
import com.zorn.startpage.core.website.dto.UpdateWebsiteDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author wzh
 * @since 2022-02-15 12:07:22
 */
@Getter
@Setter
@TableName("website")
public class Website {

    /**
     * website_id
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    public static Website create(CreateWebsiteDTO createWebsiteDTO) {
        Website website = new Website();
        website.setGroupId(Objects.requireNonNull(createWebsiteDTO.getGroupId(), ResultStatus.PARAM_IS_NULL.getMessage()));
        website.setUrl(Objects.requireNonNull(createWebsiteDTO.getUrl(), ResultStatus.PARAM_IS_NULL.getMessage()));
        return website;
    }

    public static Website update(UpdateWebsiteDTO updateWebsiteDTO) {
        Website website = new Website();
        website.setId(Objects.requireNonNull(updateWebsiteDTO.getId(), ResultStatus.PARAM_IS_NULL.getMessage()));
        website.setUrl(Objects.requireNonNull(updateWebsiteDTO.getUrl(), ResultStatus.PARAM_IS_NULL.getMessage()));
        return website;
    }
}
