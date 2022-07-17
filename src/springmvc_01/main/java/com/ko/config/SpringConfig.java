package com.ko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author Komorebi
 * @date 2022.07.15.17:50
 */

@Configuration
// @ComponentScan({"com.ko.service","com.ko.dao"})
@ComponentScan(value = "com.ko",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)
//排除使用Controller注解的bean
//这两种方式都可以
public class SpringConfig {
}
