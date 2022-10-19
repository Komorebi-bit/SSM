package com.ko.dao.user;

import com.ko.pojo.User;
import com.ko.utils.MyBatisUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Komorebi
 * @date 2022.09.26.16:13
 */
public class UserMapperTest {

    // 查询用户数
    @Test
    public void test1() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        // int count = sqlSession.selectOne("com.ko.dao.user.UserMapper.count");
        int count = sqlSession.getMapper(UserMapper.class).count();
        System.out.println("the count of users is:" + count);
        MyBatisUtil.closeSqlSession(sqlSession);
    }


    // 查询所有用户信息
    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        // List<User> userList = sqlSession.selectList("com.ko.dao.user.UserMapper.getUserList");
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserList();
        System.out.println("The count of userList ---> " + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        String userName = "孙";
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserListByName(userName);
        System.out.println("The count of userList ---> " + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        User user = new User();
        user.setUserName("孙");
        user.setUserRole(3);
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserListByUser(user);
        System.out.println("The count of userList ---> " + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        Map<String, String> map = new HashMap<>();
        map.put("uName", "孙");
        map.put("uRole", "3");
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserListByMap(map);
        System.out.println("The count of userList ---> " + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        User user = new User();
        user.setUserName("孙");
        user.setUserRole(3);
        List<User> userList = sqlSession.getMapper(UserMapper.class)
            .getUserListRoleNameByUser(user);
        System.out.println("The count of userList ---> " + userList.size());
        userList.forEach(System.out::println);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test7() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        User user = new User();
        user.setUserName("孙");
        user.setUserRole(3);
        List<User> userList = sqlSession.getMapper(UserMapper.class)
            .getUserListRoleNameByResultMap(user);
        System.out.println("The count of userList ---> " + userList.size());
        for (User u : userList) {
            System.out.println("id: " + u.getId() + "    userCode: " + u.getUserCode()
                + "    userName: " + u.getUserName() + "    userRole: " + u.getUserRole()
                + "    userRoleName: " + u.getUserRoleName());
        }
        MyBatisUtil.closeSqlSession(sqlSession);
    }






    @Test
    public void test000() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).a();
        Assert.assertNotNull(userList);
    }
}
