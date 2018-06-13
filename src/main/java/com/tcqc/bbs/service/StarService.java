package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

public interface StarService {

    /**
     * 添加收藏记录
     * @param postId 帖子id
     * @param collectionId 收藏夹id
     * @return
     */
    FormatResult<BigInteger> addStar(BigInteger postId, BigInteger collectionId);

    /**
     * 取消收藏
     * @param id
     * @return
     */
    FormatResult<BigInteger> delStar(BigInteger id);

    /**
     * 查询某个favorite下的收藏记录
     * @param id
     * @return
     */
    FormatResult<List<Star>> findAllStarByFavoriteId(BigInteger id);
}
