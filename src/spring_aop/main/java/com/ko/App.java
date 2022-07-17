package com.ko;

import com.ko.config.SpringConfig;
import com.ko.dao.BrandDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.12.23:06
 */
public class App {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandDao brandDao = (BrandDao) ctx.getBean("brandDao1");
        /*int num = brandDao.select();
        // brandDao.update();
        System.out.println(num);
        System.out.println(brandDao);
        System.out.println(brandDao.getClass());*/

        String name = brandDao.findName(100);
        System.out.println(name);
    }
}
