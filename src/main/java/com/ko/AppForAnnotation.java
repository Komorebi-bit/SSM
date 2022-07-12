package com.ko;

import com.ko.config.SpringConfig;
import com.ko.dao.Annotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author Komorebi
 * @date 2022.07.10.13:43
 */
public class AppForAnnotation {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Annotation ann = ctx.getBean(Annotation.class);
        // 也可以按名称
        DataSource ds = ctx.getBean(DataSource.class);
        ann.save();
        System.out.println(ds);
    }
}
