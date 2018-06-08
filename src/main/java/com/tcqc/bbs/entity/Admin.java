package com.tcqc.bbs.entity;

import java.math.BigInteger;

/**
 * 管理员表
 */
public class Admin {
    //管理员ID
    private BigInteger id;
    //管理员名字
    private String userName;
    //管理员的密码
    private String password;
    //管理员昵称
    private String nickname;
    //管理员性别
    private String gender;
    //管理员头像
    private String avatar;

    public String getNickname() {
        return nickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
                ", name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}