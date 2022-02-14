package com.zorn.startpage.base.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException{
    private Integer code;

    public GlobalException(String message,Integer code) {
        super(message);
        this.code = code;
    }

}
