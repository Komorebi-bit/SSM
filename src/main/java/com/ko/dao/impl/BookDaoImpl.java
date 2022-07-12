package com.ko.dao.impl;

import com.ko.dao.BookDao;

/**
 * @author Komorebi
 * @date 2022.06.07.20:55
 */
public class BookDaoImpl implements BookDao {
    private int connectionNum;
    private String dataBaseName;

    public BookDaoImpl(int connectionNum, String dataBaseName) {
        this.connectionNum = connectionNum;
        this.dataBaseName = dataBaseName;
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public BookDaoImpl(){
        System.out.println("book dao constructor is running ...");
    }
    @Override
    public void save() {
        System.out.println("book dao save ..." + dataBaseName+" "+connectionNum);
    }

    //初始化bean
    public void init(){
        System.out.println("init...");
    }

    //销毁bean
    public void destory(){
        System.out.println("destory...");
    }

}
