package com.fouo.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;

/**
 * 解决跨域配置类
 *
 * @author fouo
 * @date 2020/6/9 21:09
 * @Configuration 用于标注配置类
 */
@Configuration
public class PathCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration  = new CorsConfiguration();
        //配置跨域
            //允许哪些头跨域
        corsConfiguration.addAllowedHeader("*");
            //允许哪些请求方式跨域
        corsConfiguration.addAllowedMethod("*");
            //允许哪些请求来源进行跨域
        corsConfiguration.addAllowedOrigin("*");
            //是否允许携带Cookie进行跨域 防止跨域请求丢失Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //注册跨域的配置
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
