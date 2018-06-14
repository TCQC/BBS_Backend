package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.StarDao;
import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.service.StarService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "star")
public class StarController {
    private StarService starService;

    @Autowired
    public StarController(StarService starService) {
        this.starService = starService;
    }

    /**
     * 添加到收藏夹
     * @param favoriteId
     * @param postId
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<BigInteger> addStar(@RequestParam("favoriteId") BigInteger favoriteId, @RequestParam("postId") BigInteger postId){
        return starService.addStar(postId, favoriteId);
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.DELETE)
    public FormatResult<BigInteger> delStar(@PathVariable(value = "id")BigInteger id)
    {
        return starService.delStar(id);
    }

}
