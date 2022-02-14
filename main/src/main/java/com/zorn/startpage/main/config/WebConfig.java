package com.zorn.startpage.main.config;

import com.zorn.startpage.auth.user.filter.CORSInterceptor;
import com.zorn.startpage.auth.user.filter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CORSInterceptor corsInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Value("${path.static}")
    private String staticPath;

    String[] loginPaths = new String[]{
            "/**"
    };
    String[] unLoginPaths = new String[]{
            "/error",
            "/static/**",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/swagger-ui.html"
    };


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/"+staticPath+"/**").addResourceLocations("file:"+staticPath+System.getProperty("file.separator"));
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns(loginPaths).excludePathPatterns(unLoginPaths);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(RestController.class) || c.isAnnotationPresent(Controller.class));
//        为controller加前缀会影响swagger页面访问
        configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(RestController.class));
    }



}
