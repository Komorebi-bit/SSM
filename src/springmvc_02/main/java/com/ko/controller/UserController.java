package com.ko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Komorebi
 * @date 2022.07.16.21:27
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("save")
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "{'module':'user save ...'}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(){
        System.out.println("user delete ...");
        return "{'module':'user delete ...'}";
    }
}
