package com.tcqc.bbs.util.authentication;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Spring Mvc WEB 配置 全局添加Token验证
 */
@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    private String imgPath = "/home/tuanzi/BBS_Backend/upload/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 使用外部文件夹
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath);
    }

    /**
     * 全局允许跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
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
