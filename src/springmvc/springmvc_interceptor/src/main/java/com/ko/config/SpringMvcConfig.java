package com.ko.config;

import com.ko.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Komorebi
 * @date 2022.07.20.12:45
 */

@Configuration
@ComponentScan({"com.ko.controller","com.ko.config"})
@EnableWebMvc
public class SpringMvcConfig {
}

/*    //简化开发
    public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //只拦截当前目录的，子目录不拦截
        registry.addInterceptor(interceptor).addPathPatterns("/books","/books/*");
    }
}*/
