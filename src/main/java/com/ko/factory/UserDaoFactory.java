package com.ko.factory;

import com.ko.dao.UserDao;
import com.ko.dao.impl.UserDaoImpl;

/**
 * @author Komorebi
 * @date 2022.07.06.20:12
 */
public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
