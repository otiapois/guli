package com.fouo.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 优惠服务启动类
 *
 * @author fouo
 * @date 2020/6/2 20:15
 */
@MapperScan("com.fouo.coupon.mapper")
@SpringCloudApplication
public class CouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class,args);
    }
}
