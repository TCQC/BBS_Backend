package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface MessageDao {

    /**
     * 根据用户id查找和该用户所有的私信情况
     * @param userId 用户id
     * @return
     */

    @Select("select user.nickname, user.id user_id, user.avatar , message.content, message.id message_id, message.create_time from contact, message, user\n" +
            "where contact.user_one = #{userId} and message.id = contact.message_id and user_two = user.id\n" +
            "group by user_two;")
    List<Map<String, Object>> findAllMessageByUserId(@Param("userId")BigInteger userId);

    /**
     * 增加帖子记录
     * @param message
     * @return
     */
    @Insert("insert into message (sender_id, receiver_id, content) values(#{message.senderId}, #{message.receiverId}, #{message.content})")
    @Options(useGeneratedKeys = true, keyProperty = "message.id")
    int addMessage(@Param("message") Message message);

    /**
     * 判断两个人之前是否有联系
     * @param user_one
     * @param user_two
     * @return
     */
    @Select("select * from contact where user_one = #{user_one} and user_two = #{user_two}")
    Object isContact(@Param("user_one") BigInteger user_one, @Param("user_two") BigInteger user_two);

    /**
     * 插入联系记录
     * @param user_one
     * @param user_two
     * @param message_id
     * @return
     */
    @Insert("insert into contact (user_one, user_two, message_id) values(#{user_one}, #{user_two}, #{message_id})")
    int addContact(@Param("user_one") BigInteger user_one, @Param("user_two") BigInteger user_two, @Param("message_id") BigInteger message_id);


    /**
     * 更新联系记录
     * @param user_one
     * @param user_two
     * @param message_id
     * @return
     */
    @Update("update contact set user_one = #{user_one}, user_two = #{user_two}, message = #{message_id}")
    int updateContact(@Param("user_one") BigInteger user_one, @Param("user_two") BigInteger user_two, @Param("message_id") BigInteger message_id);

    /**
     * 根据两个人的id查找所有的聊天记录
     * @param user_one
     * @param user_two
     * @return
     */
    @Select("select * from message\n" +
            "where (message.sender_id = #{user_one} and message.receiver_id = #{user_two})\n" +
            "or    (message.receiver_id =#{user_one}  and message.sender_id = #{user_two})\n" +
            "order by create_time;")
    List<Map<String, Object>> findAllMessageByTwoId(@Param("user_one") BigInteger user_one, @Param("user_two") BigInteger user_two);

}
