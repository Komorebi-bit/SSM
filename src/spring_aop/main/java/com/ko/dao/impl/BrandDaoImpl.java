package com.ko.dao.impl;

import com.ko.dao.BrandDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author Komorebi
 * @date 2022.07.12.17:19
 */

@Repository("brandDao1")
public class BrandDaoImpl implements BrandDao {

    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("brand dao save ..");
    }

    @Override
    public void update() {
        System.out.println("brand dao update ...");
    }

    @Override
    public int select() {
        System.out.println("brand dao select ...");
        int i=1/0;
        return 100;
    }

    @Override
    public String findName(int id) {
        if(true) throw new NullPointerException();
        System.out.println("id:"+id);
        return "ko";
    }


}
