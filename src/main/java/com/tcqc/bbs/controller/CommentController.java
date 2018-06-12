package com.tcqc.bbs.controller;


import com.tcqc.bbs.service.CommentService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
//    @TokenRequired
    @RequestMapping(value = "/del/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Integer> delComment(@PathVariable(value = "id")BigInteger id){
        return commentService.delComment(id);
    }

    /**
     *
     * @param userId 用户id
     * @param postId 分类id
     * @param content 回复内容
     * @return
     */
    //    @TokenRequired
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public FormatResult<BigInteger> addComment(@RequestParam("userId") BigInteger userId, @RequestParam("postId") BigInteger postId, @RequestParam("content") String content){
        return commentService.addComment(userId,postId,content);
    }



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
