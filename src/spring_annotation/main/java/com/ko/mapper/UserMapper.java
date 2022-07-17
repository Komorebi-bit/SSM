package com.ko.mapper;

import com.ko.pojo.User;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.11.6:21
 */
public interface UserMapper {
    List<User> selectAll();
}
