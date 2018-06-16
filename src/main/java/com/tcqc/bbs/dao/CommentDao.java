package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface CommentDao {

    /**
     * 添加评论
     * @param comment 评论实体
     * @return 1为成功，0 为失败
     */
    @Insert("insert into comment(user_id, post_id, content) values(#{comment.userId}, #{comment.postId}, #{comment.content})")
    @Options(useGeneratedKeys = true, keyProperty = "comment.id")
    int addComment(@Param("comment") Comment comment);

    /**
     * 改变某条回评论的状态
     * @param id 评论id
     * @param status 评论的状态 0 为删除，1为恢复
     * @return
     */
    @Update("update comment set status = #{status} where id = #{id}")
    int changeStatusById(@Param("id") BigInteger id, @Param("status") int status);

    /**
     * 查询某个用户所有的回复
     * @param userId
     * @return
     */
    @Select("select p.id p_id, p.title p_title, c.content\n" +
            "from (select user_id, post_id, content from comment) c left join\n" +
            "(select id, title from post) p on c.post_id = p.id\n" +
            "where c.user_id = #{userId}")
    List<Map<String, Object>> getAllCommentByUserId(@Param("userId")BigInteger userId);

    /**
     * 删除用户的所有评论 该功能在删除用户时使用
     * @param userId
     * @return
     */
    @Update("update comment set status = #{status} where user_id = #{userId}")
    int changeCommentStatusByUserId(@Param("userId") BigInteger userId, @Param("status") int status);

    /**
     *删除某个帖子的评论 该功能在删除帖子时使用
     */
    @Update("update comment set status = #{status} where post_id = #{postId}")
    int changeCommentStatusByPostId(@Param("postId") BigInteger postId, @Param("status") int status);



//    /**
//     * 查询某个帖子的所有评论
//     * @param id 帖子的id
//     * @param startIndex 回复的起始标号
//     * @param pageSize 分页的大小
//     * @return 返回查询到的行数
//     */
//    @Select("select * from comment where post_id = #{id} limit #{startIndex}, #{pageSize}")
//    List<Comment> findAllCommentByPostId(@Param("id")BigInteger id, @Param("startIndex")int startIndex, @Param("pageSize")int pageSize);

}
