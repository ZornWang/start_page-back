package com.zorn.startpage.core.website.dto;

import lombok.Data;

@Data
public class CreateWebsiteDTO {
    public String url;
    public Integer groupId;

    public CreateWebsiteDTO setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
