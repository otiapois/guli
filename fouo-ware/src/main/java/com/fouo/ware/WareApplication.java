package com.fouo.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 仓储服务
 *
 * @author fouo
 * @date 2020/6/2 7:47
 */
@SpringCloudApplication
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class,args);
    }
}
