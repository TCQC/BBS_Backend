package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.PostDao;
import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.service.PostService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PostServiceImpl implements PostService {
    PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao){
        this.postDao = postDao;
    }
    @Override
    public FormatResult<Post> getPostById(BigInteger id) {
        Post post = postDao.findPostById(id);
        if (post == null){
            return FormatResultGenerator.genErrorResult("post:"+ id +" not exist");
        }
        return FormatResultGenerator.genSuccessResult(post);
    }
}
