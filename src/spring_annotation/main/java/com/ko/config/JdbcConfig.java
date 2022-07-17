package com.ko.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Komorebi
 * @date 2022.07.10.15:29
 */
public class JdbcConfig {
    // @Value("com.mysql.cj.jdbc.Driver")
    @Value("${jdbc.driver}")
    private String driver;

    // @Value("jdbc:mysql://localhost:3306/librarydb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true")
    @Value("${jdbc.url}")
    private String url;

    // @Value("root")
    @Value("${jdbc.username}")
    private String username;

    // @Value("10086")
    @Value("${jdbc.password}")
    private String password;

    /**
     * 管理第三方bean
     * 1.定义一个方法获得要管理的对象
     * 2.添加@Bean，表示当前方法的返回值是个bean
    */
    @Bean
    public DataSource dataSource(){
        //引用类型bean注入
        // System.out.println(annotation);

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
