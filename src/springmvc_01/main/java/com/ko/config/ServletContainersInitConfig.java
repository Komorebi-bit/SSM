package com.ko.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;

/**
 * @author Komorebi
 * @date 2022.07.15.17:53
 */
//4定义一个servlet容器启动的配置类，在里面加载spring的配置
//简化版
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Specify {@code @Configuration} and/or {@code @Component} classes for the
     * {@linkplain #createRootApplicationContext() root application context}.
     *
     * @return the configuration for the root application context, or {@code null}
     * if creation and registration of a root context is not desired
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * Specify {@code @Configuration} and/or {@code @Component} classes for the
     * {@linkplain #createServletApplicationContext() Servlet application context}.
     *
     * @return the configuration for the Servlet application context, or
     * {@code null} if all configuration is specified through root config classes.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * Specify the servlet mapping(s) for the {@code DispatcherServlet} &mdash;
     * for example {@code "/"}, {@code "/app"}, etc.
     *
     * @see #registerDispatcherServlet(ServletContext)
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

//经典版
/*public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    *//**
     * Create a servlet application context to be provided to the {@code DispatcherServlet}.
     * <p>The returned context is delegated to Spring's
     * {@link DispatcherServlet#DispatcherServlet(WebApplicationContext)}. As such,
     * it typically contains controllers, view resolvers, locale resolvers, and other
     * web-related beans.
     *
     * @see #registerDispatcherServlet(ServletContext)
     *
     *
     * 加载springmvc容器配置
     *//*
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    *//**
     * Specify the servlet mapping(s) for the {@code DispatcherServlet} &mdash;
     * for example {@code "/"}, {@code "/app"}, etc.
     *
     * @see #registerDispatcherServlet(ServletContext)
     *
     *
     * 设置哪些请求归属springMVC处理
     *//*
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    *//**
     * Create the "<strong>root</strong>" application context to be provided to the
     * {@code ContextLoaderListener}.
     * <p>The returned context is delegated to
     * {@link ContextLoaderListener#ContextLoaderListener(WebApplicationContext)} and will
     * be established as the parent context for any {@code DispatcherServlet} application
     * contexts. As such, it typically contains middle-tier services, data sources, etc.
     *
     * @return the root application context, or {@code null} if a root context is not
     * desired
     * @see AbstractDispatcherServletInitializer
     *
     *
     * 加载spring容器配置
     *//*
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        return ctx;
    }
}*/
