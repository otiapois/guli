package com.fouo.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 会员服务启动类
 *
 * @author fouo
 * @date 2020/6/2 7:37
 */
@MapperScan("com.fouo.order.mapper")
@SpringCloudApplication
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
    }
}
