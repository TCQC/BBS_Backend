package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Star;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StarDao {
    /**
     * 增加收藏记录
     * @param star
     * @return
     */
    @Insert("insert into star(collection_id, post_id) values(#{star.collectionId}, #{star.postId})")
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
     * 根据收藏夹id查找记录
     * @param favoriteId
     * @return
     */
    @Select("select * from star where collection_id = #{favoriteId}")
    List<Star> findAllStar(@Param("favoriteId") BigInteger favoriteId);
}
