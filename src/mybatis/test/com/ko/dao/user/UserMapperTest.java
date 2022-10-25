package com.ko.dao.user;

import com.ko.pojo.User;
import com.ko.utils.MyBatisUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public void test8(){
        SqlSession sqlSession = null;
        int count = 0;
        User user = new User();
        user.setUserCode("wangan");
        user.setUserName("网安");
        user.setUserPassword("abc123");
        user.setGender(2);
        user.setUserRole(3);
        try{
            sqlSession = MyBatisUtil.createSqlSession();
            count = sqlSession.getMapper(UserMapper.class).add(user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
            Assert.assertEquals(1,count);
        }

    }

    @Test
    public void test9(){
        SqlSession sqlSession = null;
        int count = 0;
        int id = 19;
        try{
            sqlSession = MyBatisUtil.createSqlSession();
            count = sqlSession.getMapper(UserMapper.class).deleteById(id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
            // Assert.assertEquals(1,count);
            System.out.println(count);
        }

    }

    @Test
    public void test10() throws ParseException {
        SqlSession sqlSession = null;
        int count = 0;
        User user = new User();
        user.setId(20);
        user.setUserCode("xuigaiceshi");
        user.setUserName("修改测试");
        user.setUserPassword("1230");
        user.setGender(2);
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2002-01-01");
        user.setBirthday(birthday);
        user.setPhone("13012341234");
        user.setAddress("修改测试");
        user.setModifyBy(1);
        Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-10-24 16:35:12");
        user.setModifyDate(now);
        try{
            sqlSession = MyBatisUtil.createSqlSession();
            count = sqlSession.getMapper(UserMapper.class).modify(user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
            Assert.assertEquals(1,count);
        }
    }

    @Test
    public void test11(){
        SqlSession sqlSession = null;
        int count = 0 ;
        String userName = "赵敏";
        String oldPassword = "0000000";
        String newPassword = "1234567";
        try{
            sqlSession = MyBatisUtil.createSqlSession();
            count = sqlSession.getMapper(UserMapper.class).modifyPassword(userName,oldPassword,newPassword);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
            Assert.assertEquals(1,count);
        }

    }




    @Test
    public void test000() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).a();
        Assert.assertNotNull(userList);
    }

    @Test
    public void test00(){
        Date now = new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println(format.format(now));
        // LocalDateTime now = LocalDateTime.now();
        // DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // System.out.println(now.format(formatter2));
        System.out.println(now);
    }
}
