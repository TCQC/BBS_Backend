package com.tcqc.bbs.entity.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 帖子信息
 */
public class PostInfo {
    private BigInteger id;
    private String title;
    private String nickname;
    private String status;
    private int commentSum;
    private int favoriteSum;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
    public String  toString() {
        return "PostInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", status='" + status + '\'' +
                ", commentSum=" + commentSum +
                ", favoriteSum=" + favoriteSum +
                ", updateTime=" + updateTime +
                '}';
    }
}
