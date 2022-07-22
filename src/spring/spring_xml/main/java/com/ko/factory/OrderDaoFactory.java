package com.ko.factory;

import com.ko.dao.OrderDao;
import com.ko.dao.impl.OrderDaoImpl;

/**
 * @author Komorebi
 * @date 2022.06.07.21:44
 */
public class OrderDaoFactory {

    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
