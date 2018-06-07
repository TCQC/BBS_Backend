package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;

public interface AdminService {
    /**
     * 删除用户，status设置为0
     * @param id
     * @return
     */
    FormatResult<Object> delUserById(BigInteger id);

    /**
     * 添加版块
     * @param block 版块信息（主要就一个名字)
     * @return
     */
    FormatResult<Object> addBlock(Block block);
}
