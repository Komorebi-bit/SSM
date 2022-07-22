package com.ko.service;

import com.ko.config.SpringConfig;
import com.ko.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.14.13:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTestCase {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        // System.out.println(account);
    }

    @Test
    public void testFindAll(){
        List<Account> all = accountService.findAll();
        // System.out.println(all);
    }
}
