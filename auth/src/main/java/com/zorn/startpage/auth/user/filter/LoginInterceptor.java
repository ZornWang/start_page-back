package com.zorn.startpage.auth.user.filter;

import com.alibaba.fastjson.JSON;
import com.zorn.startpage.auth.user.entity.User;
import com.zorn.startpage.auth.user.utils.JwtService;
import com.zorn.startpage.base.annotation.UnLogin;
import com.zorn.startpage.base.enums.RedisHeader;
import com.zorn.startpage.base.enums.ResultStatus;
import com.zorn.startpage.base.result.Result;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器工作");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有LoginToken注解，有则跳过认证
        if (method.isAnnotationPresent(UnLogin.class)) {
            UnLogin unLogin = method.getAnnotation(UnLogin.class);
            if (unLogin.value()) {
                return true;
            }
        }

        String authorization = request.getHeader("Authorization");

        if (authorization == null) {
            //未传入token
            String json = JSON.toJSONString(Result.error(ResultStatus.TOKEN_NOT_PROVIDE.getMessage(), ResultStatus.TOKEN_NOT_PROVIDE.getCode()));
            response.getWriter().append(json);
            return false;
        }

        String[] authorizations = authorization.split(" ");
        //判断是否为Bearer类型
        if (!authorizations[0].equals("Bearer")) {
            //token错误，不是Bearer类型
            String json = JSON.toJSONString(Result.error(ResultStatus.TOKEN_IS_ERROR.getMessage(), ResultStatus.TOKEN_IS_ERROR.getCode()));
            response.getWriter().append(json);
            return false;
        }

        String token = authorizations[1];
        //判断是否传入token
        if (token == null) {
            //未传入token
            String json = JSON.toJSONString(Result.error(ResultStatus.TOKEN_NOT_PROVIDE.getMessage(), ResultStatus.TOKEN_NOT_PROVIDE.getCode()));
            response.getWriter().append(json);
            return false;
        }

        try {
            User user = null;
            try {
                user = jwtService.getUser(token, request);
            } catch (Exception e) {
                //token错误，不能正常解析
                e.printStackTrace();
                String json = JSON.toJSONString(Result.error(ResultStatus.TOKEN_IS_ERROR.getMessage(), ResultStatus.TOKEN_IS_ERROR.getCode()));
                response.getWriter().append(json);
                return false;
            }
            if (user == null) {
                //解析后user为空
                String json = JSON.toJSONString(Result.error());
                response.getWriter().append(json);
                return false;
            }
            //成功解析

            String rightToken = this.stringRedisTemplate.opsForValue().get(RedisHeader.USER_TOKEN.getHeader() + user.getUsername());
            if (token.equals(rightToken)) {
                return true;
            } else {
                String Json= JSON.toJSONString(Result.error(ResultStatus.TOKEN_IS_ERROR.getMessage(), ResultStatus.TOKEN_IS_ERROR.getCode()));
                response.getWriter().append(Json);
                return false;
            }

        } catch (ExpiredJwtException e) {
            //token过期
            String Json = JSON.toJSONString(Result.error(ResultStatus.TOKEN_IS_EXPIRED.getMessage(), ResultStatus.TOKEN_IS_EXPIRED.getCode()));
            response.getWriter().append(Json);
            return false;
        } catch (Exception e) {
            //发生错误
            String json = JSON.toJSONString(Result.error());
            response.getWriter().append(json);
            return false;
        }
    }

}
