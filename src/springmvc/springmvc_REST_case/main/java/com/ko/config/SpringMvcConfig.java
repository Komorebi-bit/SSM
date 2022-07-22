package com.ko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan({"com.ko.controller","com.ko.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
