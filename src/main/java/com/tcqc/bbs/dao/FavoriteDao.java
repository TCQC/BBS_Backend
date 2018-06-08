package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FavoriteDao {
    /**
     * 查询用户的收藏夹
     * @param id 用户id
     * @return 收藏夹列表
     */
    @Select("select * from favorite where id = #{id}")
    List<Favorite> findFavoriteByUserId(@Param("id") BigInteger id);

    /**
     * 删除对应ID的收藏夹
     * @param id
     * @return
     */
    @Delete("delete favorite where id = #{id}")
    int delFavoriteById(@Param("id") BigInteger id);

    /**
     * 删除用户所有收藏夹
     * @param userId
     * @return
     */
    @Delete("delete favorite where user_id = #{userId}")
    int delFavoriteByUserid(@Param("userId") BigInteger userId);

    /**
     * 更新收藏夹信息（主要就是改名字)
     * @param favorite
     * @return
     */
    @Update("update favorite ")
    int putFavorite(Favorite favorite);
}
