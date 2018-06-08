package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Message;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

public interface MessageService {
    /**
     * 查询某个用户的私信列表
     * @param id
     * @param status 私信状态 0 已读，1 未读
     * @return
     */
    FormatResult<List<Message>> findAllMessageByUserId(BigInteger id, int status);

    /**
     * 查看用户所有私信 按接收方分组
     * @param id
     * @return
     */
    FormatResult<List<Message>> findAllMessageByUserId(BigInteger id);

    /**
     * 阅读私信 将status置0
     * @param id
     * @return
     */
    FormatResult<Object> readMessage(BigInteger id);

    /**
     * 发送私信 （添加私信)
     * @param message
     * @return
     */
    FormatResult<Message> addMessage(Message message);
}
