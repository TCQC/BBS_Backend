package com.tcqc.bbs.controller;


import com.tcqc.bbs.dao.ReplyDao;
import com.tcqc.bbs.entity.Reply;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "reply")
public class ReplyController {
    private ReplyDao replyDao;

    @Autowired
    public ReplyController(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }

    /**
     * 添加
     * @param reply
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<Object> addReply(@RequestBody Reply reply){
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delReply(@PathVariable(value = "id")BigInteger id){
        return null;
    }
}
