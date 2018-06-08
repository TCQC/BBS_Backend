package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

public interface StarService {
    /**
     * 查询某个favorite下的收藏记录
     * @param id
     * @return
     */
    FormatResult<List<Star>> findAllStarByFavoriteId(BigInteger id);

    /**
     * 添加收藏
     * @param star
     * @return
     */
    FormatResult<Object> addStar(Star star);

    /**
     * 取消收藏
     * @param id
     * @return
     */
    FormatResult<Object> delStar(BigInteger id);
}
