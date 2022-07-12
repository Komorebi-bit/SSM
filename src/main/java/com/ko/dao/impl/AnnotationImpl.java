package com.ko.dao.impl;

import com.ko.dao.Annotation;
import com.ko.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Scope("singleton")//prototype

/**
 * @author Komorebi
 * @date 2022.07.10.14:24
 * Bean
 */

public class AnnotationImpl implements Annotation {

    /*@Autowired
    @Qualifier("bookDao") //按名称注入，默认按类型
    private BookDao bookDao;*/

    @Value("${jdbc.username}")
    private String name;

    @Override
    public void save() {
        System.out.println("..."+name);
    }

    @PostConstruct
    public void init(){
        System.out.println("init ...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy ...");
    }
}
