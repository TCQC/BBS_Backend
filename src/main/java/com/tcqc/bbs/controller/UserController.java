package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.info.UserInfo;
import com.tcqc.bbs.service.AuthenticationService;
import com.tcqc.bbs.service.UserService;
import com.tcqc.bbs.util.authentication.TokenRequired;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public UserController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    /**
     * 查询用户信息
     * @param id 用户ID
     * @return 对应用户信息
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public FormatResult<UserInfo> getUserInfo(@PathVariable("id") BigInteger id){
        return userService.getUserInfoById(id);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public FormatResult<UserInfo> login(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password) {
        FormatResult<UserInfo> userInfoFormatResult = userService.login(username, password);
        if (userInfoFormatResult.isStatus()){
            String token = authenticationService.getToken(userInfoFormatResult.getData().getId(), password);
            userInfoFormatResult.getData().setToken(token);
            return userInfoFormatResult;
        }
        return userInfoFormatResult;
    }

    /**
     * 注册逻辑
     * @param nickname 昵称
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public FormatResult<UserInfo> register(@RequestParam(value = "nickname") String nickname, @RequestParam(value = "username") String username,
                                           @RequestParam(value = "password") String password) {
        FormatResult<UserInfo> userInfoFormatResult = userService.register(nickname, username, password);
        if (userInfoFormatResult.isStatus()){
            String token = authenticationService.getToken(userInfoFormatResult.getData().getId(), password);
            userInfoFormatResult.getData().setToken(token);
            return userInfoFormatResult;
        }
        return userInfoFormatResult;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public FormatResult<Object> putUserInfo(@RequestParam("id")BigInteger id,
                                            @RequestParam("gender")String gender,
                                            @RequestParam("avatar") String avatar,
                                            @RequestParam("workPlace")String workplace,
                                            @RequestParam("description")String description){
        return userService.putUserInfo(id,  avatar, gender, workplace, description);
    }
}