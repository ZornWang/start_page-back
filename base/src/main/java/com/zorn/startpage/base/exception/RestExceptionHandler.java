package com.zorn.startpage.base.exception;

import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.result.Result;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     *
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    public Result<String> Exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return Result.error(e.getMessage(), ResultStatus.ERROR.getCode());
    }

    @ExceptionHandler(GlobalException.class)
    public Result<String> GlobalException(GlobalException e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return Result.error(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public Result<String> ExpiredJwtException(ExpiredJwtException e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return Result.error(ResultStatus.TOKEN_NOT_PROVIDE.getMessage(), ResultStatus.TOKEN_NOT_PROVIDE.getCode());
    }

    /**
     * 请求参数错误
     *
     * @param e：请求参数错误
     * @return 102
     */
    @ExceptionHandler
    public Result<String> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(ResultStatus.PARAM_IS_ERROR.getMessage());
        log.error(e.getLocalizedMessage());
        return Result.error(ResultStatus.PARAM_IS_ERROR.getMessage(), ResultStatus.PARAM_IS_ERROR.getCode());
    }

}
