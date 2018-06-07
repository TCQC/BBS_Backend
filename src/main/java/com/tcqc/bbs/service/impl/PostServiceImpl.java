package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.PostDao;
import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import com.tcqc.bbs.service.PostService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao){
        this.postDao = postDao;
    }

    @Override
    public FormatResult<Post> getPostById(BigInteger id) {
        Post post = postDao.getPostById(id);
        if (post == null){
            return FormatResultGenerator.genErrorResult("post:"+ id +" not exist");
        }
        return FormatResultGenerator.genSuccessResult(post);
    }

    @Override
    public FormatResult<List<PostInfo>> findAllPostByCategoryId(BigInteger id, int startIndex, int pageSize, String sortType) {
       List<PostInfo> postInfos = postDao.findAllPostInfoByCategoryId(id, startIndex, pageSize, sortType);
       if (postInfos == null){
           return FormatResultGenerator.genErrorResult("category id not exist");
       }
       return FormatResultGenerator.genSuccessResult(postInfos);
    }

    @Override
    public FormatResult<List<PostInfo>> findAllPostByUserId(BigInteger id, int startIndex, int pageSize, String sortType) {
        List<PostInfo> postInfos = postDao.findAllPostInfoByUserId(id, startIndex, pageSize, sortType);
        if (postInfos == null){
            return FormatResultGenerator.genErrorResult("user id not exist");
        }
        return FormatResultGenerator.genSuccessResult(postInfos);
    }
}
