package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import com.tcqc.bbs.service.PostService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "post")
public class PostController {
    /**
     * post 默认分页大小10
     */
    private int pageSize = 10;
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    /**
     * 获取某个分类下的所有帖子
     * @param id 分类id
     * @param page 页数
     * @param sort 排序条件
     * @return
     */
    @RequestMapping(value = "/category/{id}/page/{page}/{sort}", method = RequestMethod.GET)
    public FormatResult<List<PostInfo>> findAllPostByCategoryId(@PathVariable("id")BigInteger id, @PathVariable("page") int page, @PathVariable("sort") String sort){
        int startIndex = (page - 1) * pageSize;
        return postService.findAllPostByCategoryId(id, startIndex, pageSize, sort);
    }

    /**
     * 获取某个用户的所有的post
     * @param id 用户ID
     * @param page 页数
     * @param sort 排序条件
     * @return
     */
    @RequestMapping(value = "user/{id}/page/{page}/{sort}",method = RequestMethod.GET)
    public FormatResult< List<PostInfo>> findAllPostInfoByUserId(@PathVariable("id")BigInteger id, @PathVariable("page") int page,@PathVariable("sort") String sort){
        int startIndex = (page - 1) * pageSize;
        return postService.findAllPostByUserId(id, startIndex, pageSize, sort);
    }

    /**
     * 获取对应ID 的post的详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public  FormatResult<Post>findPostById(@PathVariable("id")BigInteger id){
        return postService.getPostById(id);
    }

}
