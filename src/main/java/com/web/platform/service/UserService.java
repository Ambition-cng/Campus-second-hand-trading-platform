package com.web.platform.service;

import com.web.platform.pojo.BO.TokenBO;
import com.web.platform.pojo.User;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-12 19:55
 */
@Component
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResponseResult<TokenBO> userRegister(User user);
}
