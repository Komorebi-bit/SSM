package com.ko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Komorebi
 * @date 2022.07.10.13:39
 */

@Configuration  //代表这是配置类
@ComponentScan("com.ko") //多个用数组
@PropertySource("classpath:jdbc.properties")//多个用数组，不支持通配符
@Import({JdbcConfig.class,MybatisConfig.class})//多个用数组
public class SpringConfig {
}
