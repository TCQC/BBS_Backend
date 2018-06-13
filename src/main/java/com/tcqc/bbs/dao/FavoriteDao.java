package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Favorite;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FavoriteDao {
    /**
     * 添加收藏夹
     * @param favorite 收藏夹实体
     * @return
     */
    @Insert("insert into favorite(user_id, name) values(#{favorite.userId}, #{favorite.name})")
    @Options(useGeneratedKeys = true, keyProperty = "favorite.id")
    int addFavorite(@Param("favorite")Favorite favorite);
    /**
     * 查询用户的收藏夹
     * @param id 用户id
     * @return 收藏夹列表
     */
    @Select("select * from favorite where user_id = #{id}")
    List<Favorite> findFavoriteByUserId(@Param("id") BigInteger id);

    /**
     * 删除对应ID的收藏夹
     * @param id
     * @return
     */
    @Delete("delete from favorite where id = #{id}")
    int delFavoriteById(@Param("id") BigInteger id);

    /**
     * 删除用户所有收藏夹
     * @param userId
     * @return
     */
    @Delete("delete from favorite where user_id = #{userId}")
    int delFavoriteByUserId(@Param("userId") BigInteger userId);

    /**
     * 更新收藏夹信息（主要就是改名字)
     * @param favorite
     * @return
     */
    @Update("update favorite set favorite.name = #{favorite.name} where favorite.id = #{favorite.id}")
    int putFavorite(@Param("favorite") Favorite favorite);
}
