package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.entity.info.PostInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Map;

@Repository
public interface StarDao {
    /**
     * 增加收藏记录
     * @param star
     * @return
     */
    @Insert("insert into star(favorite_id, post_id) values(#{star.favoriteId}, #{star.postId})")
    @Options(useGeneratedKeys = true, keyProperty = "star.id")
    int addStar(@Param("star") Star star);

    /**
     * 删除记录
     * @param id
     * @return
     */
    @Delete("delete from star where id = #{id}")
    int delStar(@Param("id") BigInteger id);

    /**
     * 查找用户是否收藏某个帖子
     * @param userId 用户id
     * @param postId 帖子id
     * @return
     */
    @Select("select s.id from\n" +
                    "(select id, username from user) u left join\n" +
                    "(select id, user_id from favorite) f on u.id = f.user_id left join\n" +
                    "(select id, favorite_id, post_id from star) s on f.id = s.favorite_id left join\n" +
                    "(select id from post) p on p.id = s.post_id\n" +
                    "where u.id = #{userId} and p.id = #{postId};")
    Map<String, Object> isStar(@Param("userId") BigInteger userId, @Param("postId") BigInteger postId);
}
