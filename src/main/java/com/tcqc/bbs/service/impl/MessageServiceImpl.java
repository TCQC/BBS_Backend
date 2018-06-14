package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.MessageDao;
import com.tcqc.bbs.entity.Message;
import com.tcqc.bbs.service.MessageService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;
    @Autowired
    public MessageServiceImpl( MessageDao messageDao){
        this.messageDao = messageDao;
    }
    @Override
    public FormatResult<  List<Map<String, Object>>> findAllMessageByUserId(BigInteger id) {
        List<Map<String, Object>> list = messageDao.findAllMessageByUserId(id);
        return FormatResultGenerator.genSuccessResult(list);
    }

    @Override
    public FormatResult<BigInteger> addMessage(BigInteger sender_id, BigInteger receiver_id, String content) {
        Message message = new Message();
        message.setSenderId(sender_id);
        message.setReceiverId(receiver_id);
        message.setContent(content);
        messageDao.addMessage(message);
        if(messageDao.isContact(sender_id, receiver_id) != null){
            messageDao.updateContact(sender_id, receiver_id,message.getId());
            messageDao.updateContact(receiver_id, sender_id, message.getId());
        }else{
            messageDao.addContact(sender_id,receiver_id,message.getId());
            messageDao.addContact(receiver_id, sender_id, message.getId());
        }
        return FormatResultGenerator.genSuccessResult(message.getId());
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAllMessageByTwoId(BigInteger user_one, BigInteger user_two) {
        List<Map<String, Object>> list = messageDao.findAllMessageByTwoId(user_one, user_two);
        if(list != null){
            return FormatResultGenerator.genSuccessResult(list);
        }else{
            return FormatResultGenerator.genErrorResult("暂无消息");
        }
    }
}
