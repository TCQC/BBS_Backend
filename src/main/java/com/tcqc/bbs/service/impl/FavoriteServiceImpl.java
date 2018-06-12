package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.FavoriteDao;
import com.tcqc.bbs.entity.Favorite;
import com.tcqc.bbs.service.FavoriteService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service

public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;
    @Override
    public FormatResult<List<Favorite>> findAllFavoriteByUserId(BigInteger id) {
        return null;
    }

    @Override
    public FormatResult<Object> delFavorite(BigInteger id) {
        return null;
    }

    @Override
    public FormatResult<Object> putFavorite(String name) {
        return null;
    }

    @Override
    public FormatResult<BigInteger> addFavorite(BigInteger userId, String name) {
        return null;
    }

    @Override
    public FormatResult<Object> delFavoriteByUserId(BigInteger userId) {
        return null;
    }
}
