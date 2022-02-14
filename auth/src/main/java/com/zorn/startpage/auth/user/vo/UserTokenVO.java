package com.zorn.startpage.auth.user.vo;

import com.zorn.startpage.auth.user.entity.User;
import lombok.Data;

@Data
public class UserTokenVO {
    private String accessToken;
    private String refreshToken;
    private User user;

    public UserTokenVO() {
    }

    public UserTokenVO(String accessToken, String refreshToken, User user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }
}
