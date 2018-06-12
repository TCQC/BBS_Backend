package com.tcqc.bbs.service;

import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;

public interface CommentService {
    /**
     * 添加评论
     * @return 插入主键
     */
    FormatResult<BigInteger> addComment(BigInteger userId, BigInteger postId, String content);

    /**
     * 删除
     * @param id
     * @return
     */
    FormatResult<Integer> delComment(BigInteger id);

//    /**
//     * 分页查询某个post下的评论
//     * @param id
//     * @param page
//     * @return
//     */
//    FormatResult<List<Comment>> findAllCommentByPostId(BigInteger id, int page);

}
