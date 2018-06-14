package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.entity.info.BlockInfo;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface BlockService {
    /**
     * 使用Block id 检索对应block的信息 （包括block下的categorys)
     * @param id
     * @return
     */
    FormatResult<Block> getBlockById(BigInteger id);

    /**
     * 检索所有版块信息 （不包括categorys)
     * @return
     */
    FormatResult<List<BlockInfo>> findAllBlockInfo();

    /**
     * 版主查询自己管理的版块
     * @param id
     * @return
     */
    FormatResult<List<Map<String, Object>>> findAllBlockByAdminId(BigInteger id);





}
