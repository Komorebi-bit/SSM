package com.ko;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ko.dao.UserDao;
import com.ko.domain.User;
import com.ko.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired private UserDao userDao;

    @Test
    void testGetAll() {

        //小于less than  大于greater than

        //方式一，按条件查询
        // QueryWrapper wp = new QueryWrapper();
        // wp.lt("age",20);
        // List<User> userList = userDao.selectList(wp);
        // userList.forEach(System.out::println);

        //方式二，lambda格式按条件查询
        // QueryWrapper<User> wp = new QueryWrapper<User>();
        // wp.lambda().lt(User::getAge,10);
        // List<User> userList = userDao.selectList(wp);
        // userList.forEach(System.out::println);

        //方式三，lambda格式按条件查询（常用）
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.lt(User::getAge,10);
        // List<User> userList = userDao.selectList(lwp);
        // userList.forEach(System.out::println);

        //多条件查询
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.lt(User::getAge,30);
        // lwp.gt(User::getAge,10);
        // List<User> userList = userDao.selectList(lwp);
        // userList.forEach(System.out::println);

        //多条件查询，链式编程
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.lt(User::getAge,30)
        //    .gt(User::getAge,10);
        // List<User> userList = userDao.selectList(lwp);
        // userList.forEach(System.out::println);

        //或者条件查询
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.lt(User::getAge,10).or()
        //    .gt(User::getAge,30);
        // List<User> userList = userDao.selectList(lwp);
        // userList.forEach(System.out::println);

       /* //模拟页面传递过来的查询数据的
        UserQuery uq = new UserQuery();
        // user.setAge(10);
        uq.setAge1(30);

        //null判定
        LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        lwp.lt(null!= uq.getAge1(),User::getAge,uq.getAge1())
           .gt(null!= uq.getAge(),User::getAge,uq.getAge());
        List<User> userList = userDao.selectList(lwp);
        userList.forEach(System.out::println);*/

        //查询投影
        /*LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        lwp.select(User::getId,User::getName);*/
        /*QueryWrapper<User> lwp = new QueryWrapper<User>();
        lwp.select("id","name","age");*/
        // List<User> userList = userDao.selectList(lwp);
        // userList.forEach(System.out::println);

        //查询记录数
        // QueryWrapper<User> wp = new QueryWrapper<User>();
        // wp.select("count(id) as 总记录数, tel");
        // wp.groupBy("tel");
        // List<Map<String, Object>> userList = userDao.selectMaps(wp);
        // System.out.println(userList);

        //https://baomidou.com/pages/10c804/#abstractwrapper
        
        //条件查询 =
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.eq(User::getName,"jerry").eq(User::getPassword,"jerry1");
        // User user = userDao.selectOne(lwp);
        // System.out.println(user);

        //范围查询 lt,le,gt,ge,eq,between
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // lwp.between(User::getAge,0,30);
        // List<User> userList =userDao.selectList(lwp);
        // System.out.println(userList);

        //like
        // LambdaQueryWrapper<User> lwp = new LambdaQueryWrapper<User>();
        // // lwp.like(User::getName,"J");
        // lwp.likeRight(User::getName,"J");//J%
        // List<User> userList =userDao.selectList(lwp);
        // System.out.println(userList);

    }


}
