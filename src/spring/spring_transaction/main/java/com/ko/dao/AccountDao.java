package com.ko.dao;

import com.ko.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.14.22:27
 */

public interface AccountDao {

    @Update("update user_t set money = money + #{money} where u_name = #{name}")
    void inMoney(@Param("name") String name, @Param("money")Double money);

    @Update("update user_t set money = money - #{money} where u_name = #{name}")
    void outMoney(@Param("name") String name, @Param("money")Double money);


}
