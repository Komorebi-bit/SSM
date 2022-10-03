package com.ko.dao.user;

import com.ko.pojo.User;
import java.util.List;

/**
 * @author Komorebi
 * @date 2022.09.26.16:18
 */

public interface UserMapper {
    int count();
    List<User> getUserList();
}
