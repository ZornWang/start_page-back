package com.zorn.startpage.auth.user.dto;

import com.zorn.startpage.auth.user.entity.User;
import lombok.Data;

@Data
public class CreateUserDTO {
    public String username;
    public String password;
    public String phone;
    public String code;

    public User getUser(){
        return new User(username, password, phone);
    }
}
