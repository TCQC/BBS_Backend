package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.ReplyDao;
import com.tcqc.bbs.entity.Reply;
import com.tcqc.bbs.service.ReplyService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;


    @Override
    public FormatResult<Object> addReply(BigInteger userId, BigInteger commentId, String content) {
        Reply reply = new Reply();
        reply.setUserId(userId);
        reply.setCommentId(commentId);
        reply.setContent(content);
        replyDao.addReply(reply);
        return FormatResultGenerator.genSuccessResult(reply.getId());
    }

    @Override
    public FormatResult<Object> delReply(BigInteger id, int status) {
        int a = replyDao.changeStatuById(id,0);
        return FormatResultGenerator.genSuccessResult(a);
    }
}
