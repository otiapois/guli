package com.fouo.oauth2.config;

import org.springframework.context.annotation.Configuration;
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
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/reg.html").setViewName("reg");
    }
}
