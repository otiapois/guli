package com.fouo.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * redisson 配置类
 *
 * @author fouo
 * @date 2020/8/5 11:21
 */
@Configuration
public class RedissonConfig {

    /**
     * 所有对redisson的操作都是通过RedissonClient进行操作
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        //设置配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.127.134:6379");
        //返回实例
        return Redisson.create(config);
    }
}
