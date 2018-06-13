package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.CommentDao;
import com.tcqc.bbs.entity.Comment;
import com.tcqc.bbs.service.CommentService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@Service
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    @Override
    public FormatResult<BigInteger> addComment(BigInteger userId, BigInteger postId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setPostId(postId);
        comment.setContent(content);
        int id= commentDao.addComment(comment);
        return FormatResultGenerator.genSuccessResult(comment.getId());
    }

    @Override
    public FormatResult<Integer> delComment(BigInteger id) {
        commentDao.changeStatusById(id,0);
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<List<Map<String, Object>>> getAllCommentByUserId(BigInteger userId) {
        return FormatResultGenerator.genSuccessResult(commentDao.getAllCommentByUserId(userId));
    }

//    @Override
//    public FormatResult<List<Comment>> findAllCommentByPostId(BigInteger id, int page) {
//        return null;
//    }
}
