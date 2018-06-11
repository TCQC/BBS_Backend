package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.entity.info.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 得到后台的基本信息
     * @return 返回的是一个Map映射，包含六项属性，分别是：
     * 1.帖子总数：postNum
     * 2.帖子的近一周增长数量 weeklyPostIncreaseNum
     * 3.用户总数: userNum
     * 4.用户近一周增长的数量 weeklyUserIncreaseNum
     * 5.近一周登录的用户数量 weeklyUserLoginNum
     * 6.今日登录的用户数量 todayUserLoginNum
     *
     */
    Map<String, Object> getBasicInfoForBackend();

    /**
     * 得到最近7天得到的注册用户
     * @return 最近7天发帖数量
     */
    Map<String, Object> getLastWeekStatus();
}
