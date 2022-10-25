package com.ko.dao.user;

import com.ko.pojo.User;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author Komorebi
 * @date 2022.09.26.16:18
 */

public interface UserMapper {
    int count();
    List<User> getUserList();
    List<User> getUserListByName(String userName);
    List<User> getUserListByUser(User user);
    List<User> getUserListByMap(Map map);
    List<User> getUserListRoleNameByUser(User user);

    // @ResultMap("userList")
    // @Select("select u.*,r.roleName from smbms_user u, smbms_role r where userName like concat('%',#{userName},'%') and userRole=#{userRole} and u.userRole=r.id;")
    List<User> getUserListRoleNameByResultMap(User user);
    int add(User user);
    int deleteById(int id);
    int modify(User user);
    int modifyPassword(@Param("userName")String userName,
        @Param("oldPassword")String oldPwd,@Param("newPassword")String newPwd);


    @Select("select u.*,r.roleName from smbms_user u, smbms_role r where  u.userRole=r.id;")
    List<User> a();


}
