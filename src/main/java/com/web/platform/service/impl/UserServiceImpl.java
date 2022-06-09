package com.web.platform.service.impl;

import com.web.platform.mapper.UserMessageMapper;
import com.web.platform.pojo.BO.TokenBO;
import com.web.platform.pojo.User;
import com.web.platform.service.UserService;
import com.web.platform.utils.ResponseEnum;
import com.web.platform.utils.ResponseResult;
import com.web.platform.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-12 19:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMessageMapper userMessageMapper;

    @Resource
    private TokenUtil tokenUtil;


    @Override
    public ResponseResult<TokenBO> userRegister(User user) {
        User user1 = userMessageMapper.getUserByUid(user.getUid());
        if( user1 != null){
            return ResponseResult.fail(ResponseEnum.USER_IS_EXISTED.getCode(), ResponseEnum.USER_IS_EXISTED.getMsg());
        }
        int affectedRow = userMessageMapper.insertUser(user);
        if( affectedRow > 0){
            TokenBO tokenBO = new TokenBO(tokenUtil.tokenByUserId(user.getUid()), user);
            return ResponseResult.ok(tokenBO);
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<User> userLogin(String uid, String password) {
        User user = userMessageMapper.getUser(uid, password);
        if( user != null){
            return ResponseResult.ok(user);
        }else {
            return ResponseResult.fail(ResponseEnum.USER_LOGIN_ERROR.getCode(), ResponseEnum.USER_LOGIN_ERROR.getMsg());
        }
    }
}
