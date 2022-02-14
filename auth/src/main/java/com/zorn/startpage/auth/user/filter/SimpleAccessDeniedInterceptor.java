package com.zorn.startpage.auth.user.filter;

import com.alibaba.fastjson.JSON;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAccessDeniedInterceptor implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<Object> result = Result.error(ResultStatus.WITHOUT_PERMISSION.getMessage(), ResultStatus.WITHOUT_PERMISSION.getCode());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSON.toJSONString(result));
    }
}
