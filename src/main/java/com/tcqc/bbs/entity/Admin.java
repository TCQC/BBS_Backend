package com.tcqc.bbs.entity;

import java.math.BigInteger;

/**
 * 管理员表
 */
public class Admin {
    //管理员ID
    private BigInteger id;
    //管理员名字
    private String name;
    //管理员的密码
    private String password;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}