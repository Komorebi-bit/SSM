package com.ko.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Komorebi
 * @date 2022.09.26.15:11
 */
public class MyBatisUtil{
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";
        InputStream is;
        try {
            is = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession(){
        return factory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

}
