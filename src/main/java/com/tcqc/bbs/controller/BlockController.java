package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.BlockDao;
import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.entity.info.BlockInfo;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("block")
public class BlockController {
    private BlockDao blockDao;

    @Autowired
    public BlockController(BlockDao blockDao){
        this.blockDao = blockDao;
    }

    /**
     * 查询某个block id 下的所有categories
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public FormatResult<Block> getBlock(@PathVariable(value = "id")BigInteger id){
        return null;
    }

    /**
     * 查询所有blockinfo 主页用
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public FormatResult<List<BlockInfo>> findAllBlockInfos(){
        return null;
    }
}
