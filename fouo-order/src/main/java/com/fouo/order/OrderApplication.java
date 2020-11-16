package com.fouo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 * 订单服务启动类
 *
 * @author fouo
 * @date 2020/6/2 7:22
 */
@MapperScan("com.fouo.order.mapper")
@EnableRedisHttpSession
@EnableRabbit
@RabbitListener
@EnableFeignClients
@SpringCloudApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}