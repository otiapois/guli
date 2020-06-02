package com.fouo.product;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
/**
 * 商品服务启动类
 *
 * @author fouo
 * @date 2020/6/2 0:42
 */
@SpringCloudApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
