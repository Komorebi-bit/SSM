package com.ko.service.impl;

import com.ko.controller.Code;
import com.ko.dao.BookDao;
import com.ko.domain.Book;
import com.ko.exception.SystemException;
import com.ko.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.17.22:47
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        if(id < 1 ){
            throw new SystemException(Code.BUSINESS_ERR, "请不要使用非法字符");
        }

        // try{
        //     int i = 1 / 0;
        // }catch (Exception e){
        //     throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试！",e);
        // }

        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
