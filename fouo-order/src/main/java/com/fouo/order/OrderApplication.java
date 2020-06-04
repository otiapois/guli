package com.fouo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 订单服务启动类
 *
 * @author fouo
 * @date 2020/6/2 7:22
 */
@MapperScan("com.fouo.order.mapper")
@SpringCloudApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
