package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.service.AdminService;
import com.tcqc.bbs.service.PostService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    private int pageSize = 15;
    private AdminService adminService;
    private PostService postService;

    @Autowired
    public AdminController(AdminService adminService, PostService postService) {
        this.adminService = adminService;
        this.postService = postService;
    }


    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public FormatResult<Admin>  login(@RequestParam(value = "username") String username, @RequestParam(value = "password")String password){
        return adminService.login(username, password);
    }

    /**
     * 获取主页信息
     * @return
     */
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public FormatResult<Map<String, Object>> getIndexStatus(){
        return adminService.getIndexStatus();
    }

    /**
     * 查询用户列表
     * @param page
     * @return
     */
    @RequestMapping(value = "user/page/{page}", method = RequestMethod.GET)
    public FormatResult<List<Map<String,Object>>> findAllUser(@PathVariable(value = "page")int page){
        return adminService.findAllUser(page, pageSize);
    }

    /**
     * 模糊查询用户列表
     * @param nickname
     * @return
     */
    @RequestMapping(value = "/user/nickname/{nickname}", method = RequestMethod.GET)
    public FormatResult<List<Map<String, Object>>> searchUserByNickname(@PathVariable(value = "nickname") String nickname){
        return adminService.findAllUserByNickname(nickname);
    }
    /**
     * 获取用户列表页数
     * @return
     */
    @RequestMapping(value = "page/user", method = RequestMethod.GET)
    public FormatResult<Integer> getUserPageNum(){
        return adminService.getUserPageNum(pageSize);
    }



    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delUser(@PathVariable(value = "id")BigInteger id){
        return adminService.changeUserStatus(id, 0);
        // 删除用户所有发帖
    }

    /**
     * 恢复用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/id/{id}/", method = RequestMethod.PUT)
    public FormatResult<Object> recUser(@PathVariable(value = "id")BigInteger id){
        return adminService.changeUserStatus(id, 1);
        // 恢复用户所有发帖
    }
    /**
     * 查询用户列表
     * @param page
     * @return
     */
    @RequestMapping(value = "post/page/{page}", method = RequestMethod.GET)
    public FormatResult<List<Map<String,Object>>> findAllPost(@PathVariable(value = "page")int page){
        return adminService.findAllPost(page, pageSize);
    }

    /**
     * 获取Post列表页数
     * @return
     */
    @RequestMapping(value = "page/post", method = RequestMethod.GET)
    public FormatResult<Integer> getPostPageNum(){
        return adminService.getPostPageNum(pageSize);
    }

    /**
     * 恢复用户
     * @param id
     * @return
     */
    @RequestMapping(value = "post/id/{id}/status/{status}", method = RequestMethod.PUT)
    public FormatResult<Object> changePostStatus(@PathVariable(value = "id")BigInteger id, @PathVariable(value = "status")int status){
        return postService.changePostStatus(id, status);
    }


}