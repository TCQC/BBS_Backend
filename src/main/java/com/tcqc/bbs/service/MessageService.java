package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Message;
import com.tcqc.bbs.util.format.FormatResult;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface MessageService {
//    /**
//     * 查询某个用户的私信列表
//     * @param id
//     * @param status 私信状态 0 已读，1 未读
//     * @return
//     */
//    FormatResult<List<Message>> findAllMessageByUserId(BigInteger id, int status);

    /**
     * 查看用户所有私信 按接收方分组
     * @param id
     * @return
     */
    FormatResult<  List<Map<String, Object>>> findAllMessageByUserId(BigInteger id);

//    /**
//     * 阅读私信 将status置0
//     * @param id
//     * @return
//     */
//    FormatResult<Object> readMessage(BigInteger id);

    /**
     * 发送私信 （添加私信)
     * @param
     * @return
     */
    FormatResult<BigInteger> addMessage(BigInteger sender_id, BigInteger receiver_id,String content);


    /**
     * 根据两个人的id查找所有的聊天记录
     * @param user_one
     * @param user_two
     * @return
     */
    FormatResult<List<Map<String, Object>>> findAllMessageByTwoId( BigInteger user_one, BigInteger user_two);
}
