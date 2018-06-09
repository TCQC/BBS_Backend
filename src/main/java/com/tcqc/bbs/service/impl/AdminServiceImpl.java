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
import java.util.List;
import java.util.Map;

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
    public FormatResult<Map<String, Object>> getIndexStatus() {
        return FormatResultGenerator.genSuccessResult(adminDao.getBasicInfoForBackend());
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAllUser(int page, int size) {
        int start = (page - 1) * size;
        List<Map<String, Object>> users = userDao.findAll(start, size);
        return FormatResultGenerator.genSuccessResult(users);
    }

    @Override
    public FormatResult<Admin> login(String username, String password) {
        Admin admin = adminDao.getUserInfoByUsernameAndPassword(username, password);
        if (admin == null){
            return FormatResultGenerator.genErrorResult("用户名或密码错误");
        }
        return FormatResultGenerator.genSuccessResult(admin);
    }

    public FormatResult<Object> changeUserStatus(BigInteger id, int status) {
        int result = userDao.changeStatusById(id, status);
        if (result <= 0){
            return FormatResultGenerator.genErrorResult("用户ID不存在");
        }
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<Object> addBlock(Block block) {
        return null;
    }

    @Override
    public FormatResult<Integer> getUserPageNum(int size) {
        int num =  userDao.getUserSum();
        int sum = (num - 1) / size + 1;
        return FormatResultGenerator.genSuccessResult(sum);
    }
}
