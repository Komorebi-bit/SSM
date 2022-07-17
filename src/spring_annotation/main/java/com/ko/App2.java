package com.ko;

import com.ko.config.SpringConfig;
import com.ko.domain.Account;
import com.ko.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.11.22:07
 *
 * mybatis整合
 */
public class App2 {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account ac = accountService.findById(2);
        System.out.println(ac);
    }
}
