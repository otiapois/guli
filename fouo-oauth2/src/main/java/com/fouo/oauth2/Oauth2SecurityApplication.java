package com.fouo.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/**
 * Oauth2 安全认证启动器
 *
 * @author fouo
 * @date 2020/8/14 16:25
 */

@EnableSpringHttpSession //整合redis作为session存储
@EnableFeignClients
@SpringCloudApplication
public class Oauth2SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2SecurityApplication.class, args);
    }


}
