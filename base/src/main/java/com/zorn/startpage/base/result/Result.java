package com.zorn.startpage.base.result;

import com.zorn.startpage.base.enums.ResultStatus;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private boolean success = true;
    private Integer statusCode;
    /**
     * 结果状态 ,具体状态码参见ResultData.java
     */
    private Integer errorCode;
    private String errorMessage;
    private String message;
    private T data;
    private String path;
    private long timestamp;


    public Result() {
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        int status = httpServletResponse.getStatus();
        this.statusCode = status;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        this.path = request.getRequestURI();
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> Result<T> success(T data) {
        Result<T> resultData = new Result<>();
        resultData.setSuccess(true);
        resultData.setData(data);
        if (resultData.getStatusCode() >= 200 && resultData.getStatusCode() < 300) {
            resultData.setMessage(ResultStatus.SUCCESS.getMessage());
        }
        return resultData;
    }
    public static <T> Result<T> success() {
        Result<T> resultData = new Result<>();
        resultData.setSuccess(true);
        if (resultData.getStatusCode() >= 200 && resultData.getStatusCode() < 300) {
            resultData.setMessage(ResultStatus.SUCCESS.getMessage());
        }
        return resultData;
    }

    public static <T> Result<T> success(String message) {
        Result<T> resultData = new Result<>();
        resultData.setSuccess(true);
        resultData.setMessage(message);
        if (resultData.getStatusCode() >= 200 && resultData.getStatusCode() < 300) {
            resultData.setMessage(ResultStatus.SUCCESS.getMessage());
        }
        return resultData;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> resultData = new Result<>();
        resultData.setSuccess(true);
        resultData.setMessage(message);
        resultData.setData(data);
        if (resultData.getStatusCode() >= 200 && resultData.getStatusCode() < 300) {
            resultData.setMessage(ResultStatus.SUCCESS.getMessage());
        }
        return resultData;
    }

    public static <T> Result<T> error(String message, int code) {
        Result<T> resultData = new Result<>();
        resultData.setStatusCode(null);
        resultData.setSuccess(false);
        resultData.setErrorCode(code);
        resultData.setErrorMessage(message);
        return resultData;
    }
    public static <T> Result<T> error() {
        Result<T> resultData = new Result<>();
        resultData.setStatusCode(null);
        resultData.setSuccess(false);
        resultData.setErrorCode(ResultStatus.ERROR.getCode());
        resultData.setErrorMessage(ResultStatus.ERROR.getMessage());
        return resultData;
    }

}

