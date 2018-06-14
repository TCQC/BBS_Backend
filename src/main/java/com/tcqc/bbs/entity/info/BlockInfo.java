package com.tcqc.bbs.entity.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

public class BlockInfo {
    // 版块ID
    private BigInteger id;
    //版块名称
    private String name;

    private String icon;
    //版块拥有的分类数目
    private int categorySum;
    //版块拥有的帖子数目
    private int postSum;
    //版块下的帖子的最近更新时间
    private Timestamp updateTime;

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


    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getCategorySum() {
        return categorySum;
    }

    public void setCategorySum(int categorySum) {
        this.categorySum = categorySum;
    }

    public int getPostSum() {
        return postSum;
    }

    public void setPostSum(int postSum) {
        this.postSum = postSum;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @Override
    public String toString() {
        return "BlockInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", categorySum=" + categorySum +
                ", postSum=" + postSum +
                ", updateTime=" + updateTime +
                '}';
    }

}
