package com.ko.dao;


/**
 * @author Komorebi
 * @date 2022.07.12.17:14
 */

public interface BrandDao {
    void save();
    void update();
    int select();
    String findName(int id);
}
