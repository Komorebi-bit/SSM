package com.ko;

import com.ko.dao.OrderDao;
import com.ko.dao.impl.OrderDaoImpl;
import com.ko.factory.OrderDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Komorebi
 * @date 2022.06.07.21:47
 */
public class AppForInstanceOrder {
    public static void main(String[] args){
        // OrderDao orderDao = OrderDaoFactory.getOrderDao();
        // orderDao.save();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        orderDao.save();
    }
}
