package com.ko;

import com.ko.dao.BookDao;
import com.ko.dao.impl.BookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.06.20:55
 */
public class AppForLifeCycle {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();

        BookDao bookDao = new BookDaoImpl();
        bookDao.save();

        //暴力
        //ctx.close();
    }
}
