package com.ko;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ko.dao.UserDao;
import com.ko.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("em");
        user.setPassword("123425");
        user.setAge(20);
        user.setTel("13058569988");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1550366821103702018L);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setPassword("123425");
        userDao.updateById(user);
    }

    @Test
    void testGetById(){
        User user = userDao.selectById(1L);
        System.out.println(user);
    }

    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        // System.out.println(userList);
        userList.forEach(System.out::println);
    }

    @Test
    void testGetByPage(){
        IPage page = new Page(2,5);
        userDao.selectPage(page, null);
        System.out.println("当前页码数："+page.getCurrent());
        System.out.println("每页显示的数："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("总共多少条数据："+page.getTotal());
        System.out.println("数据：");
        page.getRecords().forEach(System.out::println);
    }

}
