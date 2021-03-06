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
     * 版主查询可以管理的版块信息
     * @param id
     * @return
     */
    @Select("select * from block where admin_user_id = #{id}")
    List<Map<String, Object>> findAllByAdminId(@Param("id")BigInteger id);

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
     * 更新block
     * @param id
     * @param name
     * @param description
     * @param adminId
     * @return
     */
    @Update("update block set name = #{name}, icon=#{icon}, description = #{description}, admin_user_id = #{adminId} where id = #{id}")
    int putBlock(@Param("id")BigInteger id, @Param("name")String name, @Param("icon") String icon, @Param("description")String description, @Param("adminId")BigInteger adminId);
}
