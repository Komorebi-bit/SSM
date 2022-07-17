package com.ko.dao.impl;

import com.ko.dao.OrderDao;

/**
 * @author Komorebi
 * @date 2022.06.07.21:42
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public void save() {
        System.out.println("order dao save ...");
    }
}
