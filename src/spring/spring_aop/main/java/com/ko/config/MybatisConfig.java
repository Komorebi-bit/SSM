package com.ko.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Komorebi
 * @date 2022.07.11.21:10
 */
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        //ssfb.setTypeAliasesPackage("com.ko.domain");
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.ko.dao");
        // 此语句引发此异常（当通过接口名.class获取bean时）
        // NoUniqueBeanDefinitionException: No qualifying bean of type 'com.ko.dao.BrandDao'
        // available: expected single matching bean but found 2: brandDaoImpl,brandDao
        return msc;
    }
}
