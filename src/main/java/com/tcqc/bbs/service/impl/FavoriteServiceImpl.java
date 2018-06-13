package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.FavoriteDao;
import com.tcqc.bbs.entity.Favorite;
import com.tcqc.bbs.service.FavoriteService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;
    @Override
    public FormatResult<List<Favorite>> findAllFavoriteByUserId(BigInteger id)
    {
        List<Favorite> list = favoriteDao.findFavoriteByUserId(id);
        return FormatResultGenerator.genSuccessResult(list);
    }

    @Override
    public FormatResult<Object> delFavorite(BigInteger id)
    {
        int a = favoriteDao.delFavoriteById(id);
        return FormatResultGenerator.genSuccessResult(a);
    }

    @Override
    public FormatResult<Object> putFavorite(BigInteger id, String name) {
        Favorite favorite = new Favorite();
        favorite.setId(id);
        favorite.setName(name);
        int a = favoriteDao.putFavorite(favorite);
        return FormatResultGenerator.genSuccessResult(a);
    }

    @Override
    public FormatResult<BigInteger> addFavorite(BigInteger userId, String name) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setName(name);
        int a = favoriteDao.addFavorite(favorite);
        return FormatResultGenerator.genSuccessResult(favorite.getId());
    }

    @Override
    public FormatResult<Object> delFavoriteByUserId(BigInteger userId) {
        int a = favoriteDao.delFavoriteByUserId(userId);
        return FormatResultGenerator.genSuccessResult(a);
    }
}
