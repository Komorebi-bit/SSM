package com.ko.pojo;

import java.io.Serializable;

/**
 * @author Komorebi
 * @date 2022.11.07.15:23
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2012053073419920513L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
