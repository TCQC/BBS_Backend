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

    FormatResult<Object> putUserInfo(BigInteger id, String avatar, String gender, String workplace, String description);
}
