package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.FavoriteDao;
import com.tcqc.bbs.entity.Favorite;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("favorite")
public class FavoriteController {
    private FavoriteDao favoriteDao;

    @Autowired
    public FavoriteController(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    /**
     * 查询用户的收藏夹
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public FormatResult<List<Favorite>> findAllFavoriteByUserId(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 添加收藏夹
     * @param favorite
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<Object> addFavorite(@RequestBody Favorite favorite){
        return null;
    }

    /**
     * 删除收藏夹
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delFavorite(@PathVariable(value = "id") BigInteger id){
        return null;
    }

    /**
     * 修改收藏夹的名称
     * @param favorite
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public FormatResult<Object> putFavorite(@RequestBody Favorite favorite){
        return null;
    }

}
