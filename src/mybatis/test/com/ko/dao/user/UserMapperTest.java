package com.ko.dao.user;

import com.ko.pojo.User;
import com.ko.utils.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Komorebi
 * @date 2022.09.26.16:13
 */
public class UserMapperTest {
    //查询用户数
    @Test
    public void test1() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        // int count = sqlSession.selectOne("com.ko.dao.user.UserMapper.count");
        int count = sqlSession.getMapper(UserMapper.class).count();
        System.out.println("the count of users is:" + count);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    //查询所有用户信息
    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        // List<User> userList = sqlSession.selectList("com.ko.dao.user.UserMapper.getUserList");
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserList();
        System.out.println("The count of userList --->" + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }
}
