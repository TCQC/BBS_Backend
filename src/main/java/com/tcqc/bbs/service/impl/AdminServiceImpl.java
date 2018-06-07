package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.UserDao;
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

    @Autowired
    public AdminServiceImpl(UserDao userDao){
        this.userDao = userDao;
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
