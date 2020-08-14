package com.fouo.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Oauth2 安全认证启动器
 *
 * @author fouo
 * @date 2020/8/14 16:25
 */
@MapperScan("com.fouo.oauth2.mapper")
@EnableCaching
@EnableFeignClients
@SpringCloudApplication
public class Oauth2SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2SecurityApplication.class,args);
    }
}
