package com.fouo.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 查询服务启动类
 * ElasticSearch
 *
 * @author fouo
 * @date 2020/7/21 10:58
 */
@MapperScan("com.fouo.search.mapper")
@EnableFeignClients
@SpringCloudApplication
public class ElasticSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }
}
