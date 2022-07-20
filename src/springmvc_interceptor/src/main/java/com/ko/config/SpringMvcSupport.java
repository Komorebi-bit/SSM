package com.ko.config;

import com.ko.controller.interceptor.ProjectInterceptor;
import com.ko.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Komorebi
 * @date 2022.07.20.13:12
 */

@Configuration //定义配置类 继承WebMvcConfigurationSupport，实现方法
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Autowired
    private ProjectInterceptor interceptor;

    @Autowired
    private ProjectInterceptor2 interceptor2;

    //配置拦截路径
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //只拦截当前目录的，子目录不拦截
        //拦截器执行的顺序，取决于这里的先后顺序
        registry.addInterceptor(interceptor).addPathPatterns("/books","/books/*");
        registry.addInterceptor(interceptor2).addPathPatterns("/books","/books/*");
    }
}
