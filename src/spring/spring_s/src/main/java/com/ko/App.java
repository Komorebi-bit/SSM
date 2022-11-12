package com.ko;

import com.ko.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * &#064;date  2022.11.07.15:16
 */
public class App {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(App.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("_userDao");
        UserDao userDao2 = context.getBean(UserDao.class);
        System.out.println(userDao);
        System.out.println(userDao2);
        userDao.save();
        logger.info(userDao2.toString());
    }
}
