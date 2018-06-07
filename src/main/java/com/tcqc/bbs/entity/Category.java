package com.tcqc.bbs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 分类表
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    //分类ID
    private BigInteger id;
    //分类所属于的版块id
    private BigInteger blockId;
    //分类名
    private String name;
    //对该分类的基本描述
    private String description;
    //该分类的状态（删除或者正常）
    private char status;
    //分类的创建时间
    private Timestamp createTime;
    //分类的更新时间
    private Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getBlockId() {
        return blockId;
    }

    public void setBlockId(BigInteger blockId) {
        this.blockId = blockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
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
        return "Category{" +
                "id=" + id +
                ", blockId=" + blockId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}