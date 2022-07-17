package com.ko.dao;

import org.apache.ibatis.annotations.Insert;

/**
 * @author Komorebi
 * @date 2022.07.15.16:48
 */

public interface LogDao {

    @Insert("insert into log(info,createDate) value (#{info},now())")
    void log(String info);
}
