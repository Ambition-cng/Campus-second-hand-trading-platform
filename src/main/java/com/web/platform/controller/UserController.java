package com.web.platform.controller;

import com.web.platform.pojo.BO.TokenBO;
import com.web.platform.pojo.User;
import com.web.platform.service.UserService;
import com.web.platform.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hly
 * @Description: 用户相关接口
 * @create 2022-05-12 20:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 已上线
     * 用户注册接口
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<TokenBO> userRegister(@RequestBody User user){
        return userService.userRegister(user);
    }

    /**
     * 已上线
     * 用户登录接口
     * @param uid
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<User> userLogin(String uid, String password){
        return userService.userLogin(uid, password);
    }
}
