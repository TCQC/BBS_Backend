package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.FavoriteDao;
import com.tcqc.bbs.entity.Favorite;
import com.tcqc.bbs.service.FavoriteService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    /**
     * 添加收藏夹
     * @param userId 用户id
     * @param name 收藏夹名称
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<BigInteger> addFavorite(@RequestParam("userId") BigInteger userId, @RequestParam("name") String name){
        return favoriteService.addFavorite(userId,name);
    }

    /**
     * 按照收藏夹id删除收藏夹
     * @param id 收藏夹id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delFavorite(@PathVariable(value = "id") BigInteger id){
        return favoriteService.delFavorite(id);
    }

    /**
     * 按照userId删除收藏夹
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delFavoriteByUserId(@PathVariable("id") BigInteger id){
        return favoriteService.delFavoriteByUserId(id);
    }

    /**
     * 查询用户的收藏夹
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public FormatResult<List<Favorite>> findAllFavoriteByUserId(@PathVariable(value = "id") BigInteger id){
        return favoriteService.findAllFavoriteByUserId(id);
    }

    /**
     * 修改收藏夹的名称
     * @param id 收藏夹id
     * @param name 收藏夹名称
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public FormatResult<Object> putFavorite(@RequestParam("id")BigInteger id, @RequestParam("name")String name){
        return favoriteService.putFavorite(id, name);
    }
}
