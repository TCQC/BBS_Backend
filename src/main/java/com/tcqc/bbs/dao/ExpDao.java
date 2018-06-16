package com.tcqc.bbs.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ExpDao {

    /**
     * 给某个用户增加经验
     * @param username
     * @param exp
     * @return
     */
    @Update("update user set exp = exp + #{exp} where username = #{username}")
    int addExpByUsername(@Param("username")String  username, @Param("exp")int exp);


    /**
     * 给某个用户增加经验
     * @param userId
     * @param exp
     * @return
     */
    @Update("update user set exp = exp + #{exp} where id = #{userId}")
    int addExpByUserId(@Param("userId")BigInteger  userId, @Param("exp")int exp);
}
