package com.ko;

import com.ko.dao.BookDao;
import com.ko.service.BookService;
import com.ko.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * @date 2022.05.28.22:36
 */
public class Main {
    public static void main(String[] args){
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // App app = (App)context.getBean("app");
        // app.sayHello();

        // BookService bookService = new BookServiceImpl();
        // bookService.save();

        //获取IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // BookDao bookDao1 = (BookDao) context.getBean("bookDao");
        // BookDao bookDao2 = (BookDao) context.getBean("bookDao");
        // System.out.println(bookDao1);
        // System.out.println(bookDao2);

        // BookService bookService = (BookService) context.getBean("bookService");
        // bookService.save();

        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
    }
}
