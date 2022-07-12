package com.ko;

import com.ko.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.06.21:22
 */
public class AppForDISet {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

    }
}
