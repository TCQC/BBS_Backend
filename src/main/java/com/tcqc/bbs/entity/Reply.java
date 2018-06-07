package com.tcqc.bbs.entity;

import com.tcqc.bbs.entity.info.UserInfo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 二级回复列表
 */
public class Reply {
    //回复ID
    private BigInteger id;
    //所回复的评论ID
    private BigInteger commentId;
    //该条回复的回复者
    private UserInfo user;
    //该条回复的回复内容
    private String content;
    //回复的创建时间
    private Timestamp createTime;
    //回复的更新时间
    private Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getCommentId() {
        return commentId;
    }

    public void setCommentId(BigInteger commentId) {
        this.commentId = commentId;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Reply{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}