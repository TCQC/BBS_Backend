package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Comment;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @return 插入主键
     */
    BigInteger addComment(Comment comment);

    /**
     * 删除
     * @param id
     * @return
     */
    int delComment(BigInteger id);

    /**
     * 分页查询某个post下的评论
     * @param id
     * @param page
     * @return
     */
    FormatResult<List<Comment>> findAllCommentByPostId(BigInteger id, int page);

}
