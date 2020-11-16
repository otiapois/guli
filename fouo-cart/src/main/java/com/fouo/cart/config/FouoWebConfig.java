package com.fouo.cart.config;

import com.fouo.cart.interceptor.CartInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  定制springmvc的页面跳转配置
 *
 * @author fouo
 * @date 2020/8/17 16:59
 */
@Configuration
public class FouoWebConfig implements WebMvcConfigurer {
    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cartList.html").setViewName("cartList");
        registry.addViewController("/success.html").setViewName("success");
    }

    /**
     * 用于添加拦截器
     * 使拦截器生效
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor()).addPathPatterns("/**");
    }
}