package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.AdminDao;
import com.tcqc.bbs.dao.UserDao;
import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.entity.Block;
import com.tcqc.bbs.service.AdminService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AdminServiceImpl implements AdminService {
    private UserDao userDao;
    private AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(UserDao userDao, AdminDao adminDao) {
        this.userDao = userDao;
        this.adminDao = adminDao;
    }


    @Override
    public FormatResult<Admin> login(String username, String password) {
        Admin admin = adminDao.getUserInfoByUsernameAndPassword(username, password);
        if (admin == null){
            return FormatResultGenerator.genErrorResult("用户名或密码错误");
        }
        return FormatResultGenerator.genSuccessResult(admin);
    }

    public FormatResult<Object> delUserById(BigInteger id) {
        int result = userDao.delById(id);
        if (result <= 0){
            return FormatResultGenerator.genErrorResult("用户ID不存在");
        }
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<Object> addBlock(Block block) {
        return null;
    }
}
