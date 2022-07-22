package com.ko.service.impl;

import com.ko.dao.BookDao;
import com.ko.dao.UserDao;
import com.ko.service.BookService;

/**
 * @author Komorebi
 * @date 2022.07.06.21:55
 */
public class BookServiceImpl_1 implements BookService {
    private BookDao bookDao;
    private UserDao userDao;

    public BookServiceImpl_1(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("book service ...");
        bookDao.save();
        userDao.save();
    }
}
