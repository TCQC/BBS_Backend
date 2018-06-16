package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ReplyDao {
    /**
     * 添加回复
     * @param reply 回复实体
     * @return 1为成功，0 为失败
     */
    @Insert("insert into reply(user_id, comment_id, content) values(#{reply.userId},#{reply.commentId}, #{reply.content})")
    @Options(useGeneratedKeys = true, keyProperty = "reply.id")
    int addReply(@Param("reply") Reply reply);
    /**
     * 改变某条回复的状态
     * @param id 回复id
     * @param status 回复的状态 0 为删除，1为恢复
     * @return
     */
    @Update("update reply set status = #{status} where id = #{id}")
    int changeStatuById(@Param("id") BigInteger id, @Param("status") int status);

    /**
     * 删除某个用户所有的回复
     * @param userId
     * @param status
     * @return
     */
    @Update("update reply set status = #{status} where user_id = #{userId} ")
    int changeStatusByUserId(@Param("userId") BigInteger userId, @Param("status") int status);

}
