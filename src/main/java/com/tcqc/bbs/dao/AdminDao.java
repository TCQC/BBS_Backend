package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.entity.info.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    /**
     * 使用用户名和密码查询数据库
     * @param username
     * @param password
     * @return 对应用户信息
     */
    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin getUserInfoByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
