package com.ko.controller;

import com.ko.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.16.21:55
 */

@Controller
public class UserController {

    //普通参数
    @RequestMapping("/commonParam")
    @ResponseBody
    //参数名不一致时
    public String commonParam(@RequestParam("name") String username, int age){
        System.out.println("普通参数传递 name ---> "+username);
        System.out.println("普通参数传递 age ---> "+age);
        return "{'module':'common param'}";
    }

    //POJO参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("POJO参数传递 user ---> "+user);
        return "{'module':'pojo param'}";
    }

    //嵌套POJO参数
    @RequestMapping("/pojoContainPOJOParam")
    @ResponseBody
    public String pojoContainPOJOParam(User user){
        System.out.println("POJO嵌套pojo参数传递 user ---> "+user);
        return "{'module':'pojo contain pojo param'}";
    }

    //数组参数
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ---> "+ Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    //集合参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ---> "+ likes);
        return "{'module':'list param'}";
    }

    //集合参数：json格式
    @RequestMapping("/listParamForJson")
    @ResponseBody
    //@RequestBody 一个方法中只能使用一次 用于接收json数据
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list common(json)参数传递 list ---> "+ likes);
        return "{'module':'list common for json param'}";
    }

    //POJO参数：json格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){
        System.out.println("pojo(json)参数传递 user ---> "+ user);
        return "{'module':'pojo for json param'}";
    }

    //集合参数：json格式
    @RequestMapping("/listpojoParamForJson")
    @ResponseBody
    public String listpojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ---> "+ list);
        return "{'module':'list pojo for json param'}";
    }

    //日期参数 默认格式yyyy/MM/dd
    //Converter<S,T>接口 类型转换器
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date3
                            )
    {
        System.out.println("参数传递 date ---> "+date);
        System.out.println("参数传递 date(yyyy-MM-dd) ---> " + date2);
        System.out.println("参数传递 date(yyyy-MM-dd HH:mm:ss) ---> " + date3);
        return "{'module':'date param'}";
    }

    //响应页面/跳转页面
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "index.jsp";
    }

    //响应文本数据
    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println("返回纯文本数据");
        return "response text";
    }

    //响应POJO对象
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    //Jackson包下的HttpMessageConverter接口负责转换json数据
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setName("ko");
        user.setAge(18);
        return user;
    }

    //响应POJO集合对象
    @RequestMapping("/toJsonList")
    @ResponseBody //设置当前控制器返回值作为响应体
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User();
        user1.setName("ko");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("黑马程序员");
        user2.setAge(18);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }
}