package com.fouo.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/**
 * 购物车微服务启动类
 *
 * @author fouo
 * @date 2020/8/28 15:18
 */
@MapperScan("com.fouo.cart.mapper")
@EnableSpringHttpSession
@EnableCaching
@EnableFeignClients
@SpringCloudApplication
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}