package com.web.platform.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

/**
 * token工具类
 *
 * @author hly
 * @version 1.0
 * @date 2020/2/3 15:22
 */
@Component
public class TokenUtil {

    /**
     * 根据userId生成token
     *
     * @param userId
     * @return
     */
    public  String tokenByUserId(String userId) {
        String token = "";
        /**
         * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
         * withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
         * 小程序登录没有密码
         */
        token = JWT.create().withAudience(userId)
                .sign(Algorithm.HMAC256(userId));
        return token;
    }

}
