package com.tcqc.bbs.entity.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 帖子的基本信息，包括收藏量，评论量等
 */
public class PostInfo {
    //帖子的id
    private BigInteger id;
    //帖子的标题
    private String title;
    private BigInteger userId;
    //帖子主人的昵称
    private String nickname;

    private String avatar;
    //帖子的状态
    private int status;
    //帖子的评论量
    private int commentSum;
    //帖子的收藏量
    private int favoriteSum;
    //帖子的最后更新时间
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCommentSum() {
        return commentSum;
    }

    public void setCommentSum(int commentSum) {
        this.commentSum = commentSum;
    }

    public int getFavoriteSum() {
        return favoriteSum;
    }

    public void setFavoriteSum(int favoriteSum) {
        this.favoriteSum = favoriteSum;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                ", commentSum=" + commentSum +
                ", favoriteSum=" + favoriteSum +
                ", updateTime=" + updateTime +
                '}';
    }
}
