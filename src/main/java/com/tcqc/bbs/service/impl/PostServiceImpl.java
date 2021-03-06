package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.ExpDao;
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
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    private PostDao postDao;
    private ExpDao expDao;

    @Autowired
    public PostServiceImpl(PostDao postDao, ExpDao expDao){
        this.postDao = postDao;
        this.expDao = expDao;
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
    public FormatResult<List<PostInfo>> findAllPostByBlockId(BigInteger blockId, int startIndex, int pageSize, String sortType) {
        List<PostInfo> postInfos = postDao.findAllPostInfoByBlockId(blockId, startIndex, pageSize, sortType);
        if(postInfos == null){
            return FormatResultGenerator.genErrorResult("block is not exist");
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

    @Override
    public FormatResult<List<PostInfo>> findQuestionByUserId(BigInteger id, int startIndex, int pageSize, String sortType) {
        List<PostInfo> postInfos = postDao.findQuestionByUserId(id, startIndex, pageSize, sortType);
        if (postInfos == null){
            return FormatResultGenerator.genErrorResult("user id not exist");
        }
        return FormatResultGenerator.genSuccessResult(postInfos);
    }

    @Override
    public FormatResult<List<PostInfo>> findAllPostByFavoriteId(BigInteger id, int startIndex, int pageSize, String sortType) {
        List<PostInfo> postInfos = postDao.findAllPostInfoByFavoriteId(id, startIndex, pageSize, sortType);
        if (postInfos == null){
            return FormatResultGenerator.genErrorResult("favorite id not exist");
        }
        return FormatResultGenerator.genSuccessResult(postInfos);
    }
    @Override
    public FormatResult<List<PostInfo>> findAllPostInfoByKeyword(String keyword, int startIndex, int pageSize, String sortType){
        return FormatResultGenerator.genSuccessResult(postDao.findAllPostInfoByKeyword(keyword, startIndex, pageSize, sortType));
    }

    @Override
    public FormatResult<BigInteger> addPost(BigInteger userId, BigInteger categoryId, String title, String content) {
        Post post = new Post();
        post.setUserId(userId); post.setCategoryId(categoryId);
        post.setTitle(title); post.setContent(content);
        postDao.addPost(post);
        expDao.addExpByUserId(userId, 5);
        return FormatResultGenerator.genSuccessResult(post.getId());
    }

    @Override
    public FormatResult<Object> putPost(BigInteger id,BigInteger userId, BigInteger categoryId, String title, String content) {
        Post post = new Post();
        post.setId(id);
        post.setUserId(userId); post.setCategoryId(categoryId);
        post.setTitle(title); post.setContent(content);
        postDao.putPost(post);
        return FormatResultGenerator.genSuccessResult();
    }


    @Override
    public FormatResult<Object> changePostStatus(BigInteger id, int status) {
        int i =  postDao.changePostStatusById(id, status);
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<List<PostInfo>> getHotPost() {
        List<PostInfo> list = postDao.getHotPost();
        return FormatResultGenerator.genSuccessResult(list);
    }

    @Override
    public FormatResult<Map<String, Object>> getNumberInfoByUserId(BigInteger id) {
        Map<String ,Object> map = postDao.getNumberInfoByUserId(id);
        return FormatResultGenerator.genSuccessResult(map);
    }


}
