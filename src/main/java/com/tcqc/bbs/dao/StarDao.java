package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.entity.info.PostInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

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

}
