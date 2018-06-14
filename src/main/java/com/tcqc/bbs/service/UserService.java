package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.info.UserInfo;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    FormatResult<UserInfo> login(String username, String password);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    FormatResult<UserInfo> getUserInfoById(BigInteger id);

    /**
     * 注册新用户
     * @param nickname
     * @param username
     * @param password
     * @return
     */
    FormatResult<UserInfo> register(String nickname, String username, String password);

    /**
     * 更新用户信息
     * @param id
     * @param avatar
     * @param gender
     * @param workplace
     * @param description
     * @return
     */
    FormatResult<UserInfo> putUserInfo(BigInteger id, String avatar, String gender, String workplace, String description);
}
