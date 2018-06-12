package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.entity.info.BlockInfo;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from block where status = 1")
    List<Map<String, Object>> findAll();

    /**
     * 加载所有版块信息 （主页加载用）
     * @return
     */
    List<BlockInfo> findAllBlockInfo();

    /**
     * 加载某个版块的所有categorys 信息
     * @param id
     * @return
     */
    Block getBlockById(BigInteger id);

    /**
     * 改变某个版块的状态 （status: 0 删除 1 恢复)
     * 管理员用
     * @param id
     * @return
     */
    @Update("update block set status = #{status} where id = #{id}")
    int changeStatusById(@Param("id") BigInteger id, @Param("status") int status);


    /**
     * 添加版块
     * @param name
     * @param icon
     * @param description
     * @return
     */
    @Insert("insert into block(name, icon, description, admin_user_id) values(#{name}, #{icon}, #{description}, #{admin_user_id})")
    int addBlock(@Param("name")String name, @Param("icon") String icon, @Param("description")String description, @Param("admin_user_id")BigInteger id);

    /**
     * 更新版块信息
     * @param block block对象
     * @return
     */
    @Update("update block set name = #{block.name}, description = #{block.description} where id = #{block.id}")
    int putBlock(@Param("block") Block block);
}
