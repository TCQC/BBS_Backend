package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.*;
import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.service.AdminService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    private UserDao userDao;
    private AdminDao adminDao;
    private PostDao postDao;
    private BlockDao blockDao;
    private CommentDao commentDao;
    private ReplyDao replyDao;

    @Autowired
    public AdminServiceImpl(UserDao userDao, AdminDao adminDao, PostDao postDao, BlockDao blockDao, CommentDao commentDao, ReplyDao replyDao ) {
        this.userDao = userDao;
        this.adminDao = adminDao;
        this.postDao = postDao;
        this.blockDao = blockDao;
        this.commentDao = commentDao;
        this.replyDao = replyDao;
    }

    @Override
    public FormatResult<Map<String, Object>> getIndexStatus() {
        return FormatResultGenerator.genSuccessResult(adminDao.getBasicInfoForBackend());
    }

    @Override
    public FormatResult<Map<String, Object>> getLastWeekStatus() {
        Map<String, Object> map = adminDao.getLastWeekStatus();
        return FormatResultGenerator.genSuccessResult(map);
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAllUser(int page, int size) {
        int start = (page - 1) * size;
        List<Map<String, Object>> users = userDao.findAll(start, size);
        return FormatResultGenerator.genSuccessResult(users);
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAllPost(int page, int size) {
        int start = (page -1) * size;
        List<Map<String, Object>> posts = postDao.findAll(start, size);
        return FormatResultGenerator.genSuccessResult(posts);
    }

    @Override
    public FormatResult<Admin> login(String username, String password) {
        Admin admin = adminDao.getUserInfoByUsernameAndPassword(username, password);
        if (admin == null){
            return FormatResultGenerator.genErrorResult("用户名或密码错误");
        }
        return FormatResultGenerator.genSuccessResult(admin);
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAllUserByNickname(String pattern) {
        String p = "%" + pattern + "%";
        List<Map<String, Object>> users = userDao.findAllByNickname(p);
        return FormatResultGenerator.genSuccessResult(users);
    }

    @Override
    public FormatResult<Object> changeUserStatus(BigInteger id, int status) {
        int result = userDao.changeStatusById(id, status);
        if (result <= 0){
            return FormatResultGenerator.genErrorResult("用户ID不存在");
        }

        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public void changeAllStatusOfUser(BigInteger id, int status){
        postDao.changeAllPostStatusByUserId(id, status);
        commentDao.changeCommentStatusByUserId(id, status);
        replyDao.changeStatusByUserId(id, status);
    }

    @Override
    @Transactional
    public FormatResult<Object> addBlock(String name, String icon, String description, BigInteger id) {
        int i  =  blockDao.addBlock(name, icon, description, id);
        if (i == 0){
            return FormatResultGenerator.genErrorResult("无法创建block");
        }
        userDao.changeStatusById(id, 2);
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<Object> putBlock(BigInteger id, String name, String icon, String description, BigInteger adminId) {
        int i = blockDao.putBlock(id, name, icon, description, adminId);
        if (i == 0){
            return FormatResultGenerator.genErrorResult("block ID 不存在");
        }
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<Object> delBlock(BigInteger id) {
        int i = blockDao.changeStatusById(id,0);
        if (i == 0)
            return FormatResultGenerator.genErrorResult("无法删除ID: " + id);
        return FormatResultGenerator.genSuccessResult();
    }

    @Override
    public FormatResult<List<Map<String, Object>>> findAll() {
        List<Map<String, Object>> list = blockDao.findAll();
        return FormatResultGenerator.genSuccessResult(list);
    }


    @Override
    public FormatResult<Integer> getUserPageNum(int size) {
        int num =  userDao.getUserSum();
        int sum = (num - 1) / size + 1;
        return FormatResultGenerator.genSuccessResult(sum);
    }

    @Override
    public FormatResult<Integer> getPostPageNum(int size) {
        int num =  postDao.getPostSum();
        int sum = (num - 1) / size + 1;
        return FormatResultGenerator.genSuccessResult(sum);
    }
}
