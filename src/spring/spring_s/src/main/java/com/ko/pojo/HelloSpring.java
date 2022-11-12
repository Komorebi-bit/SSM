package com.ko.pojo;

/**
 * @author Komorebi
 * @date 2022.11.07.16:05
 */
public class HelloSpring {
    private String who;
    private String content;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print(){
        System.out.println("Hello,"+this.getWho()+"!");
    }
    public void tell(){
        System.out.println(this.getWho()+"说："+this.getContent());
    }
}
