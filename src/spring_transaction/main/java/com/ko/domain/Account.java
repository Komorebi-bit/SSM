package com.ko.domain;

/**
 * @author Komorebi
 * @date 2022.07.14.22:41
 */

public class Account {
    private int id;
    private String u_name;
    private String u_password;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", money=" + money +
                '}';
    }

}
