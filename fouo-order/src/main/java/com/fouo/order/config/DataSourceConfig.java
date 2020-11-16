package com.fouo.order.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


/**
 * Seata数据源
 *
 * @author fouo
 * @date 2020/9/22 11:01
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return new DataSourceProxy(dataSource);
    }
}
