package com.zorn.startpage.auth.user.dto;

import com.zorn.startpage.auth.user.entity.User;
import lombok.Data;

@Data
public class UpdateUserDTO extends CreateUserDTO{
    private Integer id;
    private String avatarUrl;
    private String signature;

    @Override
    public User getUser() {
        User user = super.getUser();
        user.setId(id);
        return user;
    }

    public UpdateUserDTO setId(Integer id) {
        this.id = id;
        return this;
    }
}
