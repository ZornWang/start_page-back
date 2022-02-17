package com.zorn.startpage.base.dto;

import lombok.Data;

@Data
public class PageinateDto {
    private Long size;
    private Long current;
}
