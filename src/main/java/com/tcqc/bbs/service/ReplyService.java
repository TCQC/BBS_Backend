package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Reply;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;

public interface ReplyService {
    /**
     * 添加2级回复
     * @param reply
     * @return
     */
    FormatResult<Object> addReply(Reply reply);

    /**
     * 删除二级回复 （id)
     * @param id
     * @return
     */
    FormatResult<Object> delReply(BigInteger id);
}
