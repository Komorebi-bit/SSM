package com.ko;

import com.ko.dao.FoodDao;
import com.ko.dao.impl.FoodDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.09.23:04
 */
public class AppForDICollection {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // FoodDao foodDao = (FoodDao) ctx.getBean("foodDao");
        FoodDao foodDao = ctx.getBean("foodDao",FoodDao.class);
        // FoodDao foodDao = ctx.getBean(FoodDao.class);

        foodDao.save();
    }
}
