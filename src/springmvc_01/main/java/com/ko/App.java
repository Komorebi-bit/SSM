package com.ko;

import com.ko.config.SpringConfig;
import com.ko.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Komorebi
 * @date 2022.07.16.20:32
 */
public class App {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        /*ctx.register(SpringConfig.class);
        ctx.refresh();*/
        System.out.println(ctx.getBean(UserController.class));
    }
}
