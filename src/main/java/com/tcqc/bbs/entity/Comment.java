package com.tcqc.bbs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcqc.bbs.entity.info.UserInfo;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * 对帖子的回复列表，也就是一级回复，之后的reply对象是二级回复
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {
    //回复ID
    private BigInteger id;
    //该条回复的回复者信息
    private UserInfo user;
    // 该评论下的回复
    private List<Reply> replies;
    //该条回复的回复内容
    private String content;
    //该条回复的状态（是否被设为禁止展示）
    private char status;
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

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", replies=" + replies +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}