package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.StarDao;
import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.service.StarService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
@Service
public class StarServiceImpl implements StarService {
    @Autowired
    private StarDao starDao;

    @Override
    public FormatResult<BigInteger> addStar(BigInteger postId, BigInteger favoriteId) {
        Star star = new Star();
        star.setPostId(postId);
        star.setFavoriteId(favoriteId);
        starDao.addStar(star);
        return FormatResultGenerator.genSuccessResult(star.getId());
    }

    @Override
    public FormatResult<BigInteger> delStar(BigInteger id) {
        starDao.delStar(id);
        return FormatResultGenerator.genSuccessResult();
    }

}
