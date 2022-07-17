package com.ko.config;

import org.springframework.context.annotation.*;

/**
 * @author Komorebi
 * @date 2022.07.10.13:39
 */

@Configuration  //代表这是配置类
@ComponentScan("com.ko") //多个用数组
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy  //开启注解开发AOP功能
public class SpringConfig {

}
