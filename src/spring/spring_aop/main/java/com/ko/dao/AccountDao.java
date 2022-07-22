package com.ko.dao;

import com.ko.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountDao {

    @Insert("insert into user_t(u_name,u_password,money)values(#{u_name},#{u_password},#{money})")
    void save(Account account);

    @Delete("delete from user_t where id = #{id} ")
    void delete(Integer id);

    @Update("update user_t set u_name = #{u_name} , u_password = #{u_password}, money = #{money} where id = #{id} ")
    void update(Account account);

    @Select("select * from user_t")
    List<Account> findAll();

    @Select("select * from user_t where id = #{id} ")
    Account findById(Integer id);
}