package com.ko.domain;

import java.io.Serializable;

public class Account implements Serializable {

    private Integer id;
    private String u_name;
    private String u_password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                '}';
    }
}
