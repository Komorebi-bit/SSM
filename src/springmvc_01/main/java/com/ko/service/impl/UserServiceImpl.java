package com.ko.service.impl;

import com.ko.domain.User;
import com.ko.service.UserService;

/**
 * @author Komorebi
 * @date 2022.07.16.20:07
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save(User user) {
        System.out.println("user service ...");
    }
}
