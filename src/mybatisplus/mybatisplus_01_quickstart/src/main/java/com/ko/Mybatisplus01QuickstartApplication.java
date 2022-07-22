package com.ko;

import com.ko.config.MyBatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Komorebi
 */
@SpringBootApplication
// @Import(MyBatisPlusConfig.class)//让他扫描到mp配置类
public class Mybatisplus01QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisplus01QuickstartApplication.class, args);
    }

}
