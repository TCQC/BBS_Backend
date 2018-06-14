package com.tcqc.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Block {
    //版块ID
    private BigInteger id;
    // 版主ID
    private BigInteger adminUserId;
    //版块名称
    private String name;
    // 版块图标
    private String icon;
    //版块的描述信息
    private String description;
    //版块的状态
    private int  status;
    //版块的创建时间
    private Timestamp createTime;
    //版块的更新时间
    private Timestamp updateTime;
    //版块下面的所有的目录信息
    private List<Category> categories;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(BigInteger adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
        return "Block{" +
                "id=" + id +
                ", adminUserId=" + adminUserId +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", categories=" + categories +
                '}';
    }
}
