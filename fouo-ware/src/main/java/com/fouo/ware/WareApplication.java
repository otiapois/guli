package com.fouo.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 仓储服务
 *
 * @author fouo
 * @date 2020/6/2 7:47
 */
@EnableTransactionManagement
@MapperScan("com.fouo.ware.mapper")
@SpringCloudApplication
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class,args);
    }
}
