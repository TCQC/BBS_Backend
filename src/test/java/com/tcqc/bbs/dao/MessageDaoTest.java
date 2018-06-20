package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Message;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {

    @Autowired
    private MessageDao messageDao;
    @Test
    public void addMessage() {
        BigInteger senderId = BigInteger.valueOf(15);
        BigInteger receiverId = BigInteger.valueOf(17);
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        System.out.println(messageDao.isContact(senderId, receiverId));
    }


}