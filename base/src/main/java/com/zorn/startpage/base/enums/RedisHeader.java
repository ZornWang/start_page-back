package com.zorn.startpage.base.enums;

public enum RedisHeader {
    USER_TOKEN("userToken"),
    USER_REFRESH_TOKEN("userRefreshToken"),
    RETRIEVE_PASSWORD_CODE("retrievePasswordCode"),
    REGISTER_CODE("registerCode");

    private String header;

    RedisHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
