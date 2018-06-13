package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.StarDao;
import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.service.StarService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "star")
public class StarController {
    private StarService starService;

    @Autowired
    public StarController(StarService starService) {
        this.starService = starService;
    }

    /**
     * 添加收藏
     * @param collectionId 收藏夹id
     * @param postId     帖子id
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<BigInteger> addStar(@RequestParam("collectionId") BigInteger collectionId, @RequestParam("postId") BigInteger postId){
        return starService.addStar(postId, collectionId);
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
