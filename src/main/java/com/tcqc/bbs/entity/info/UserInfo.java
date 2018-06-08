package com.tcqc.bbs.entity.info;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigInteger;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    // 用户ID
    private BigInteger id;
    // 用户昵称
    private String nickname;
    // 头像
    private String avatar;
    // 用户经验值
    private int exp;
    // 用户等级名称
    private String rank;
    // 用户简介
    private String description;
    // 用户
    private String token;
    // 用户状态
    private int status;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Timestamp lastLoginTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", exp=" + exp +
                ", rank='" + rank + '\'' +
                ", description='" + description + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
