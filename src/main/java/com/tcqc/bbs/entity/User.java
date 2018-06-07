package com.tcqc.bbs.entity;

import com.tcqc.bbs.entity.info.UserInfo;

import java.math.BigInteger;
import java.sql.Timestamp;


public class User {
    //用户id
    private BigInteger id;
    //用户名字
    private String username;
    //用户密码
    private String password;
    //用户信息
    private UserInfo userInfo;
    //用户创建时间
    private Timestamp createTime;
    //用户信息修改时间
    private Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


}