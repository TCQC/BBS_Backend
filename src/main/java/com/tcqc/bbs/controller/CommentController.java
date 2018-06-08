package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.CommentDao;
import com.tcqc.bbs.entity.Comment;
import com.tcqc.bbs.util.authentication.TokenRequired;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("comment")
public class CommentController {
    private CommentDao commentDao;

    @Autowired
    public CommentController(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
//    @TokenRequired
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delComment(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 添加评论
     * @param params
     * @return
     */
    //    @TokenRequired
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<BigInteger> addComment(@RequestBody Map<String, Object> params){
        // 可以用params.get方法获取参数
        return null;
    }

    /**
     * 查询某post下的评论
     * @param id
     * @param page 页数
     * @return
     */
    @RequestMapping(value = "/post/{id}/page/{page}", method = RequestMethod.GET)
    public FormatResult<List<Comment>> findAllCommentByPostId(@PathVariable(value = "id") BigInteger id, @PathVariable(value = "page") int page){
        return null;
    }
}
