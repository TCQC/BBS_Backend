package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CategoryDao {

    @Select("select * from category where status = 1")
    List<Category> findAll();

    @Select("select * from category where status = 1 and block_id = #{blockId}")
    List<Category> findAllByBlockId(BigInteger id);

    @Insert("insert into category (block_id, name, description) value (#{blockId}, #{name}, #{description})")
    int addCategory(@Param(value = "blockId")BigInteger id, @Param(value = "name")String name, @Param(value = "description")String description);

    @Update("update category set status = 0 where id = #{id}")
    int delCategory(@Param(value = "id") BigInteger id);
}
