package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.MessageDao;
import com.tcqc.bbs.entity.Message;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "message")
public class MessageController {
    private MessageDao messageDao;

    @Autowired
    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    /**
     * 查询用户的所有未读信息
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}/unread", method = RequestMethod.GET)
    public FormatResult<List<Message>> findAllUnreadMessage(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 查询用户所有私信
     * 需不需要再说
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}/all", method = RequestMethod.GET)
    public FormatResult<List<Message>> findAllMessage(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 发送私信
     * @param message
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<Object> addMessage(@RequestBody Message message){
        return null;
    }

    /**
     * 标记私信已读
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> readMessage(@PathVariable(value = "id") BigInteger id){
        return null;
    }

}

