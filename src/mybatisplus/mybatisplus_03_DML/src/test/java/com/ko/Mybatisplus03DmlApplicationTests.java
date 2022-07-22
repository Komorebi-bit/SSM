package com.ko;

import com.ko.dao.UserDao;
import com.ko.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("ko");
        user.setPassword("10010");
        user.setAge(25);
        user.setTel("100100100");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        //多记录删除
        // List<Long> list = new ArrayList<>();
        // list.add(1550366447361871873L);
        // list.add(1550370878753144834L);
        // list.add(1550464667760738306L);
        // userDao.deleteBatchIds(list);

        //多记录查询
        // List<Long> ls = Arrays.asList(1L,2L,3L);
        // userDao.selectBatchIds(ls);

        userDao.deleteById(1L);
        // System.out.println(userDao.selectList(null));//想要全部数据，自己写sql语句
    }

    @Test
    void testUpdate(){
        /*//1.0先通过要修改的数据id,将当前数据查询出来
        User user = userDao.selectById(3L);
        //2.0将要修改的数据逐一设置进去
        user.setName("Jock888");
        userDao.updateById(user);*/

        //乐观锁案例
        //1.0先通过要修改的数据id,将当前数据查询出来
        User user1 = userDao.selectById(3L);  //version=2
        User user2 = userDao.selectById(3L);  //version=2

        user1.setName("Jock--");
        userDao.updateById(user1);             //version=3

        user2.setName("Jock++");
        userDao.updateById(user2);
    }
}
