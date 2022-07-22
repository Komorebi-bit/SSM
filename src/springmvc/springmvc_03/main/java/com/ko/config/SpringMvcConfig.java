package com.ko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Komorebi
 * @date 2022.07.16.21:20
 */

@Configuration
@ComponentScan("com.ko.controller")
@EnableWebMvc//1.开启json数据转换对象的功能
//2.根据类型匹配对应的类型转换器 Converter接口里面的（有些默认未开启，需要通过他开启）
public class SpringMvcConfig {
}
