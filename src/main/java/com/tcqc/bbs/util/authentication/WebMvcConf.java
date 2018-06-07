package com.tcqc.bbs.util.authentication;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Mvc WEB 配置 全局添加Token验证
 */
@Configuration
@EnableWebMvc
public class WebMvcConf implements WebMvcConfigurer {
    private String imgPath = "/home/tuanzi/bbs-backend/upload/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 使用外部文件夹
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath).addResourceLocations("classpath:/static/");;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @TokenRequired 注解 决定是否需要登录
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public HandlerInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
