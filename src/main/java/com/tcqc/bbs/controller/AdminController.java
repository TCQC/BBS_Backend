package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.Admin;
import com.tcqc.bbs.service.AdminService;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public FormatResult<Admin>  login(@RequestParam(value = "username") String username, @RequestParam(value = "password")String password){
        return adminService.login(username, password);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return "success";
    }
}
