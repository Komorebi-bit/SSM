package com.ko.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author Komorebi
 * @date 2022.07.14.22:23
 */

public interface AccountService {

    /**
     * 转账操作
     * @param out 传出方
     * @param in 传入方
     * @param money  金额
     */

    @Transactional(rollbackFor = IOException.class)
    //开启事务，也可以写在类上，表示类中所有的方法都开启了事务
    //运行时异常，error类型才会引起事务回滚
    void transfer(String out, String in, double money) throws IOException;

}
