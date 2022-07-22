package com.ko.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Komorebi
 * @date 2022.07.15.16:44
 */
public interface LogService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    //propagation 事务传播行为  REQUIRES_NEW开启新事物（独立）
    void log(String out, String in, double money);
}
