package com.fouo.order.config;

import com.fouo.order.interceptor.LoginUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  使拦截器生效配置
 *
 * @author fouo
 * @date 2020/8/17 16:59
 */
@Configuration
public class FouoWebConfig implements WebMvcConfigurer {

    /**
     * 用于添加拦截器
     * 使拦截器生效
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginUserInterceptor()).addPathPatterns("/**");
    }
}