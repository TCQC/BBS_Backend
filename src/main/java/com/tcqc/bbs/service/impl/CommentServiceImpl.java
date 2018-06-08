package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.CommentDao;
import com.tcqc.bbs.entity.Comment;
import com.tcqc.bbs.service.CommentService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    @Override
    public BigInteger addComment(Comment comment) {
        return null;
    }

    @Override
    public int delComment(BigInteger id) {
        return 0;
    }

    @Override
    public FormatResult<List<Comment>> findAllCommentByPostId(BigInteger id, int page) {
        return null;
    }
}
