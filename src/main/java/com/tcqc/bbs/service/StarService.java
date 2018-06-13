package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

public interface StarService {

    /**
     * 添加收藏
     * @param postId
     * @param favoriteId
     * @return
     */
    FormatResult<BigInteger> addStar(BigInteger postId, BigInteger favoriteId);

    /**
     * 取消收藏
     * @param id
     * @return
     */
    FormatResult<BigInteger> delStar(BigInteger id);

}
