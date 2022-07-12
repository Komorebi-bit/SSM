package com.ko.dao.impl;

import com.ko.dao.FoodDao;

import java.util.*;

/**
 * @author Komorebi
 * @date 2022.07.09.22:50
 */
public class FoodDaoImpl implements FoodDao {
    private int[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save(){
        System.out.println("food dao save ...");

        System.out.println("遍历数组"+Arrays.toString(array));
        System.out.println("遍历list"+list);
        System.out.println("遍历set"+set);
        System.out.println("遍历map"+map);
        System.out.println("遍历properties"+properties);
    }
}
