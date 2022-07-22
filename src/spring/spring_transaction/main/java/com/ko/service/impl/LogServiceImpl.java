package com.ko.service.impl;

import com.ko.dao.LogDao;
import com.ko.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Komorebi
 * @date 2022.07.15.16:46
 */

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void log(String out, String in, double money) {
        logDao.log("转账操作由"+out+"到"+in+"，金额："+money);
    }
}
