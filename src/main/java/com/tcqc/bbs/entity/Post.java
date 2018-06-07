package com.tcqc.bbs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcqc.bbs.entity.info.UserInfo;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * 帖子表
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    //帖子ID
    private Integer id;
    //发帖人
    private UserInfo user;
    //帖子的分类ID
    private BigInteger categoryId;
    //帖子的主题
    private String title;
    //帖子的内容
    private String content;

    private List<Comment> comments;
    //帖子的状态( 0 删除 1 普通 2 加精 3 置顶)
    private  char status;
    //帖子的创建时间
    private Timestamp createTime;
    //帖子的更新时间
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}