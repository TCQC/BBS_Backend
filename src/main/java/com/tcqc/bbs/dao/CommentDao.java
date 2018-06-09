package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

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
     * 改变某条回复的状态
     * @param id 评论id
     * @param status 评论的状态 0 为删除，1为恢复
     * @return
     */
    @Update("update comment set status = #{status} where id = #{id}")
    int changeStatusById(@Param("id") BigInteger id, @Param("status") int status);


    /**
     * 查询某个帖子的所有回复
     * @param id 帖子的id
     * @param startIndex 回复的起始标号
     * @param pageSize 分页的大小
     * @return 返回查询到的行数
     */
    @Select("select * from comment where post_id = #{id} limit #{startIndex}, #{pageSize}")
    List<Comment> findAllCommentByPostId(@Param("id")BigInteger id, @Param("startIndex")int startIndex, @Param("pageSize")int pageSize);

//    /**
//     * 查询某post下的评论
//     * @param id
//     * @param page 页数
//     * @return
//     */
//    @RequestMapping(value = "/post/{id}/page/{page}", method = RequestMethod.GET)
//    public FormatResult<List<Comment>> findAllCommentByPostId(@PathVariable(value = "id") BigInteger id, @PathVariable(value = "page") int page){
//        return null;
//    }
}
