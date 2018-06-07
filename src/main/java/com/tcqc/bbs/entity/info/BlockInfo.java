package com.tcqc.bbs.entity.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

public class BlockInfo {
    private BigInteger id;
    private String name;
    private int category_sum;
    private int post_sum;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
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

    public int getCategory_sum() {
        return category_sum;
    }

    public void setCategory_sum(int category_sum) {
        this.category_sum = category_sum;
    }

    public int getPost_sum() {
        return post_sum;
    }

    public void setPost_sum(int post_sum) {
        this.post_sum = post_sum;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BlockInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category_sum=" + category_sum +
                ", post_sum=" + post_sum +
                ", updateTime=" + updateTime +
                '}';
    }
}
