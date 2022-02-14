package com.zorn.startpage.base.enums;

public enum COSUrl {
    USERAVATAR("/userAvatar/"),
    USERBACKGROUND("/userBackground/");
    private String url;

    COSUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
