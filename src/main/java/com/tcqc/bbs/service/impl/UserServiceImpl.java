package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.UserDao;
import com.tcqc.bbs.entity.info.UserInfo;
import com.tcqc.bbs.service.UserService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public FormatResult<UserInfo> login(String username, String password) {
        UserInfo userInfo = userDao.getUserInfoByUsernameAndPassword(username, password);
        if (userInfo == null){
            return FormatResultGenerator.genErrorResult("用户名或密码不正确");
        }
        return FormatResultGenerator.genSuccessResult(userInfo);
    }

    @Override
    public FormatResult<UserInfo> getUserInfoById(BigInteger id) {
        UserInfo userInfo = userDao.getUserInfoById(id);
        if (userInfo == null){
            return FormatResultGenerator.genErrorResult("用户ID不存在");
        }
        return FormatResultGenerator.genSuccessResult(userInfo);
    }

    @Override
    public FormatResult<UserInfo> register(String nickname, String username, String password) {
        if (userDao.isNicknameExist(nickname) != null)
            return FormatResultGenerator.genErrorResult("用户名已存在");
        if (userDao.isUsernameExist(username) != null)
            return FormatResultGenerator.genErrorResult("账号已被注册");
        int result = userDao.addUser(username, password, nickname);
        if (result == 0)
            return FormatResultGenerator.genErrorResult("无法插入数据库");
        UserInfo userInfo = userDao.getUserInfoByUsernameAndPassword(username, password);
        return  FormatResultGenerator.genSuccessResult(userInfo);
    }





}
