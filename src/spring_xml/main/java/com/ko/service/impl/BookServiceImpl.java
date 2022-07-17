package com.ko.service.impl;

import com.ko.dao.BookDao;
import com.ko.dao.UserDao;
import com.ko.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Komorebi
 * @date 2022.06.07.20:56
 */
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    //删除new
    // private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;
    private UserDao userDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setBookDao(BookDao bookDao) {
        System.out.println("set ...");
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("service destory ...");
    }

    //注意set顺序
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init ...");
    }
}
