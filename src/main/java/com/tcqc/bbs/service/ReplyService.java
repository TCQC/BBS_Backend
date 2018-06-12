package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Reply;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;

public interface ReplyService {

    /**
     * 添加2级回复
     * @param userId 回复者id
     * @param commentId  回复的评论id
     * @param content 回复内容
     * @return
     */
    FormatResult<Object> addReply(BigInteger userId, BigInteger commentId, String content);

    /**
     * 删除二级回复 （id)
     * @param id 回复
     * @param status 状态
     */
    FormatResult<Object> delReply(BigInteger id, int status);
}
