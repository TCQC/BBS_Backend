package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.service.AdminService;
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

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
     * 查询用户列表
     * @param page
     * @return
     */
    @RequestMapping(value = "users/page/{page}", method = RequestMethod.GET)
    public FormatResult<List<Map<String,Object>>> findAllUser(@PathVariable(value = "page")int page){
        return adminService.findAllUser(page, pageSize);
    }

    /**
     * 用户取用列表总页数
     * @return
     */
    @RequestMapping(value = "page/users", method = RequestMethod.GET)
    public FormatResult<Integer> getUserPage(){
        return adminService.getUserPageNum(pageSize);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delUser(@PathVariable(value = "id")BigInteger id){
        return adminService.changeUserStatus(id, 0);
    }

    /**
     * 恢复用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public FormatResult<Object> recUser(@PathVariable(value = "id")BigInteger id){
        return adminService.changeUserStatus(id, 1);
    }

    /**
     * 获取主页信息
     * @return
     */
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public FormatResult<Map<String, Object>> getIndexStatus(){
        return adminService.getIndexStatus();
    }
}
