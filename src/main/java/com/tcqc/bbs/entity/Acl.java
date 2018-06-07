package com.tcqc.bbs.entity;

import java.math.BigInteger;

//权限信息表
public class Acl {
    //每条记录的id
    private BigInteger id;
    //每条权限的多对应的用户id
    private BigInteger userId;
    //赋予该用户版块信息的管理员id
    private BigInteger adminId;
    //被赋予权限的版块id
    private BigInteger blockId;

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

    public BigInteger getAdminId() {
        return adminId;
    }

    public void setAdminId(BigInteger adminId) {
        this.adminId = adminId;
    }

    public BigInteger getBlockId() {
        return blockId;
    }

    public void setBlockId(BigInteger blockId) {
        this.blockId = blockId;
    }

    @Override
    public String toString() {
        return "Acl{" +
                "id=" + id +
                ", userId=" + userId +
                ", adminId=" + adminId +
                ", blockId=" + blockId +
                '}';
    }
}