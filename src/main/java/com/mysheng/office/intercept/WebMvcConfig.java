package com.mysheng.office.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public AppInterceptor securityInterceptor() {
        return new AppInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(securityInterceptor());
    }
//    @Bean
//    public AppInterceptor securityInterceptor() {
//        return new AppInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加拦截器
//        registry.addInterceptor(securityInterceptor());
//    }

}
