package com.ko.dao.provider;

import com.ko.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * @author Komorebi
 * @date 2022.09.09.21:42
 */
public class ProviderMapperTest {

    //查询供应商数
    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        int count = sqlSession.selectOne("com.ko.dao.provider.ProviderMapper.count");
        System.out.println("the count of providers is:" + count);
        MyBatisUtil.closeSqlSession(sqlSession);
    }

}
