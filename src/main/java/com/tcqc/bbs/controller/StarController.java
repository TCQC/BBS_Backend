package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.StarDao;
import com.tcqc.bbs.entity.Star;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "star")
public class StarController {
    private StarDao starDao;

    @Autowired
    public StarController(StarDao starDao) {
        this.starDao = starDao;
    }

    /**
     * 添加收藏
     * @param star
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<Object> addStar(@RequestBody Star star){
        return null;
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delStar(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 查询收藏夹下的收藏记录
     * @param id
     * @return
     */
    @RequestMapping(value = "favorite/{id}", method = RequestMethod.DELETE)
    public FormatResult<List<Star>> findAllStar(@PathVariable(value = "id")BigInteger id){
        return null;
    }
}
