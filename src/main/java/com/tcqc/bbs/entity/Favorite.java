package com.tcqc.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Favorite {
    //收藏夹ID
    private BigInteger id;
    //收藏夹的主人ID
    private BigInteger userId;
    //收藏夹的名称
    private String name;
    //收藏夹的创建时间
    private Timestamp createTime;
    //收藏夹的更新时间
    private Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
