package com.ko.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ko.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Komorebi
 * @date 2022.07.22.13:50
 */

@Mapper
public interface UserDao extends BaseMapper<User> {
}
