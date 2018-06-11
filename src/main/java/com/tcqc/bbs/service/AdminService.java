package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface AdminService {
    /**
     * 加载主页信息
     * @return
     */
    FormatResult<Map<String, Object>> getIndexStatus();

    /**
     * 获得近七天每天发帖数目
     * @return
     */
    FormatResult<Map<String, Object>> getLastWeekStatus();
    /**
     * 查询所有用户列表
     * @param page
     * @param size
     * @return
     */
    FormatResult<List<Map<String, Object>>> findAllUser(int page, int size);

    /**
     * 查询所有Post
     * @param page
     * @param size
     * @return
     */
    FormatResult<List<Map<String, Object>>> findAllPost(int page, int size);

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    FormatResult<Admin> login(String username, String password);

    /**
     * 使用昵称模糊查询用户列表
     * @param pattern
     * @return
     */
    FormatResult<List<Map<String, Object>>> findAllUserByNickname(String pattern);

    /**
     * 修改用户状态
     * @param id
     * @return
     */
    FormatResult<Object> changeUserStatus(BigInteger id, int status);


    /**
     * 添加版块
     * @param block 版块信息（主要就一个名字)
     * @return
     */
    FormatResult<Object> addBlock(Block block);

    /**
     * 得到用户页面数
     * @return
     */
    FormatResult<Integer> getUserPageNum(int size);

    /**
     * 得到Post页面页数
     * @return
     */
    FormatResult<Integer> getPostPageNum(int size);
}
