package com.ko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Komorebi
 * @date 2022.07.15.17:50
 */

//3创建springmvc的配置文件，加载controller对应的bean
// @Configuration //会影响SpringConfig的扫描排除，所以注释掉
@ComponentScan("com.ko.controller")
public class SpringMvcConfig {
}
