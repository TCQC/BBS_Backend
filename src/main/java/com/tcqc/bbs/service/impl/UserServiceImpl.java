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
        } else if (userInfo.getStatus() == 0){
            return FormatResultGenerator.genErrorResult("该用户已被拉黑");
        }
        return FormatResultGenerator.genSuccessResult(userInfo);
    }

    @Override
    public FormatResult<UserInfo> register(String nickname, String username, String password) {
        if (userDao.isNicknameExist(nickname) != null)
            return FormatResultGenerator.genErrorResult("昵称已经存在");
        if (userDao.isUsernameExist(username) != null)
            return FormatResultGenerator.genErrorResult("邮箱已被注册");
        int result = userDao.addUser(username, password, nickname);
        if (result == 0)
            return FormatResultGenerator.genErrorResult("无法插入数据库");
        UserInfo userInfo = userDao.getUserInfoByUsernameAndPassword(username, password);
        return  FormatResultGenerator.genSuccessResult(userInfo);
    }

    @Override
    public FormatResult<Object> putUserInfo(BigInteger id, String avatar, String gender, String workplace, String description) {
        int i = userDao.putUserInfo(id, avatar, gender, workplace, description);
        if (i == 0){
            return FormatResultGenerator.genErrorResult("update userinfo error");
        }
        return FormatResultGenerator.genSuccessResult();
    }


}
