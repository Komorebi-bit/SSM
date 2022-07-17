package com.ko.service.impl;

import com.ko.domain.Account;
import com.ko.service.AccountService;
import com.ko.dao.AccountDao;
import com.ko.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.14.22:26
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private LogService logService;

    /**
     * 转账操作
     * @param out   传出方
     * @param in    传入方
     * @param money 金额
     */
    @Override
    public void transfer(String out, String in, double money) throws IOException {
        //运行时异常，error类型才会引起事务回滚
        try{
            accountDao.outMoney(out,money);
            int i=1/0;
            accountDao.inMoney(in,money);
        }finally {
            logService.log(out,in,money);
        }

    }

}
