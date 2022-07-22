package com.ko.dao.impl;

import com.ko.dao.UserDao;

/**
 * @author Komorebi
 * @date 2022.07.06.20:09
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user dao save...");
    }
}
