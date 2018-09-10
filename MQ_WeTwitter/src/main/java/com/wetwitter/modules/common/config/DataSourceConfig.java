package com.wetwitter.modules.common.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据源配置
 * @author sunwei
 *
 */
@Configuration
public class DataSourceConfig 
{
	@Bean(name = "dataSource")
    @Qualifier("dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource defaultDataSource() {
        DataSource ds = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return ds;
    }

}
