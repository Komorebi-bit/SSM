package com.ko.factory;

import com.ko.dao.UserDao;
import com.ko.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Komorebi
 * @date 2022.07.06.20:31
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {

    /**
     * 代替原始实例工厂中创建对象的方法
     */
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    /**
     * 上面的对象是什么类型的
     */
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    /**
     * 默认单例
     * @return
     */
    @Override
    public boolean isSingleton(){
        return true;
    }
}
