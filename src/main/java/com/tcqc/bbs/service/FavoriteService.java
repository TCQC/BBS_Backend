package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Favorite;
import com.tcqc.bbs.util.format.FormatResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface FavoriteService {
    /**
     * 查询某用户的收藏夹
     * @param id
     * @return
     */
    FormatResult<List<Favorite>> findAllFavoriteByUserId(BigInteger id);

    /**
     * 删除favorite
     * @param id
     * @return 插入信息，成功则genSucess , 否则genError
     */
    FormatResult<Object> delFavorite(BigInteger id);

    /**
     * 更新favorite
     * 能更新的属性只有名称
     * @param id 收藏夹id
     * @param name
     * @return 插入信息，成功则genSucess , 否则genError
     */
    FormatResult<Object> putFavorite(BigInteger id, String name);

    /**
     * 添加favorite
     * @param userId 收藏夹主人
     * @param name  收藏夹名称
     * @return  成功返回主键
     */
    FormatResult<BigInteger> addFavorite(BigInteger userId, String name);

    /**
     * 删除用户所有收藏夹
     * @param userId
     * @retur
     */
    FormatResult<Object> delFavoriteByUserId(@Param("userId") BigInteger userId);
}
