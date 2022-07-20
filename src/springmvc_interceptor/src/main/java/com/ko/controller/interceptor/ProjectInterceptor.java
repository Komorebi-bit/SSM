package com.ko.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Komorebi
 * @date 2022.07.20.13:05
 */

@Component  //声明拦截器的bean， 并受SpringMvc管理，扫描加载bean
public class ProjectInterceptor implements HandlerInterceptor {

    //在原始被拦截的操作之前运行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getHeader("Content-Type"));
        // System.out.println(handler.getClass());
        HandlerMethod hm = (HandlerMethod) handler;
        //hm.getMethod();//拿到原始方法
        System.out.println("preHandle ...");
        //true放行，false不放行 ，若false，后面的操作不执行。
        return true;
    }

    //在原始被拦截的操作之后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //modelAndView 封装了mvc页面跳转的相关数据
        System.out.println("postHandle ...");
    }

    //在原始被拦截的操作之后运行，并且在post之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //ex  拿到原始方法执行过程中抛出的异常
        System.out.println("afterHandle ...");
    }
}
