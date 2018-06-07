package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.entity.info.BlockInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface BlockDao {
    /**
     * 查看所有Block记录
     * 管理员用
     * @return
     */
    @Select("select * from block")
    List<Map<String, Object>> findAll();

    /**
     * 加载所有版块信息 （主页加载用）
     * @return
     */
    List<BlockInfo> getAllBlockInfos();

    /**
     * 加载某个版块的所有categorys 信息
     * @param id
     * @return
     */
    Block getBlockById(BigInteger id);

    /**
     * 删除某个版块 （设置status = 0)
     * @param id
     * @return
     */
    @Update("update block set status = 0 where id = #{id}")
    int delBlockById(@Param("id") BigInteger id);


    // 添加版块
    int addBlock(Block block);

    //更新版块信息
    int putBlock(Block block);
}
