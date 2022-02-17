package com.zorn.startpage.auth.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zorn.startpage.auth.user.dto.UpdateUserDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzh
 * @since 2022-02-14 04:26:42
 */
@Data
@TableName("user")
public class User {

    public interface insert {
    }

    public interface update {
    }

    public interface edit{
    }

    /**
     * user_id
     */
    @TableId(type = IdType.AUTO)
    @NotNull(message = "id不能为空",groups = {edit.class})
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    @NotNull(message = "username不能为空", groups = {insert.class})
    private String username;

    /**
     * 用户密码
     */
    @NotNull(message = "password不能为空", groups = {insert.class})
    @TableField("password")
    @JsonBackReference
    private String password;

    /**
     * 头像url
     */
    @TableField("avatar_url")
    private String avatarUrl;

    /**
     * 用户签名
     */
    @TableField("signature")
    private String signature;

    /**
     * 用户手机号
     */
    @TableField("phone")
    private String phone;

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

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User(Integer id, String username, String password, String avatarUrl, String signature, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.signature = signature;
        this.phone = phone;
    }

    public User(UpdateUserDTO updateUserDTO) {
        this.id = updateUserDTO.getId();
        this.username = updateUserDTO.getUsername();
        this.password = updateUserDTO.getPassword();
        this.avatarUrl = updateUserDTO.getAvatarUrl();
        this.signature = updateUserDTO.getSignature();
        this.phone = updateUserDTO.getPhone();
    }
}
