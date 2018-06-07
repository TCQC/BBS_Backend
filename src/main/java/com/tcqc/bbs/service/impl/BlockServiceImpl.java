package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.BlockDao;
import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.entity.info.BlockInfo;
import com.tcqc.bbs.service.BlockService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class BlockServiceImpl implements BlockService {
    private BlockDao blockDao;

    @Autowired
    public BlockServiceImpl(BlockDao blockDao){
        this.blockDao = blockDao;
    }


    @Override
    public FormatResult<Block> getBlockById(BigInteger id) {
        return null;
    }

    @Override
    public FormatResult<List<BlockInfo>> findAllBlockInfo() {
        return null;
    }
}
