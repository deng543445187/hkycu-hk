package com.huike.ycu.mybatis.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String sex;
    private String nick_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer() {
    }

    public Customer(String username, String password, String sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
    }
}
