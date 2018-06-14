package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.MessageDao;
import com.tcqc.bbs.entity.Message;
import com.tcqc.bbs.service.MessageService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "message")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

//    /**
//     * 查询用户的所有未读信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "user/{id}/unread", method = RequestMethod.GET)
//    public FormatResult<List<Message>> findAllUnreadMessage(@PathVariable(value = "id")BigInteger id){
//        return null;
//    }

//    /**
//     * 查询用户所有私信
//     * 需不需要再说
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "user/{id}/all", method = RequestMethod.GET)
//    public FormatResult<List<Message>> findAllMessage(@PathVariable(value = "id")BigInteger id){
//        return null;
//    }

    /**
     * 发送私信
     * @param senderId
     * @param receiverId
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<BigInteger> addMessage(@RequestParam("senderId") BigInteger senderId, @RequestParam("receiverId") BigInteger receiverId, @RequestParam("content") String content){
        return messageService.addMessage(senderId, receiverId, content);
    }

    /**
     * 根据某个人的id查找所有对话列表
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public FormatResult<  List<Map<String, Object>>> findAllMessageByUserId(@PathVariable("id") BigInteger id){
        return messageService.findAllMessageByUserId(id);
    }

    /**
     * 根据id查找两个人的信息
     * @param user_one
     * @param user_two
     * @return
     */
    @RequestMapping(value = "one/{one}/two/{two}" , method = RequestMethod.GET)
    public FormatResult<List<Map<String, Object>>> findAllMessageByTwoId(@PathVariable("one") BigInteger user_one, @PathVariable("two") BigInteger user_two){
        return messageService.findAllMessageByTwoId(user_one,user_two);
    }
//    /**
//     * 标记私信已读
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "id/{id}", method = RequestMethod.DELETE)
//    public FormatResult<Object> readMessage(@PathVariable(value = "id") BigInteger id){
//        return null;
//    }

}

