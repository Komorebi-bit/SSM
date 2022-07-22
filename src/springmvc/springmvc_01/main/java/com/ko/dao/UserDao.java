package com.ko.dao;

import com.ko.domain.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Komorebi
 * @date 2022.07.16.20:08
 */

public interface UserDao {

    @Insert("insert into user_t(u_name,u_password,money) value(#{username},#{password},#{money})")
    void save(User user);
}
