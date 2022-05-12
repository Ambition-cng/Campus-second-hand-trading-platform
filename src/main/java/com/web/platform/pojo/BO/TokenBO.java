package com.web.platform.pojo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: hly
 * @Date: 2021/4/30 10:30
 */
@Data
@AllArgsConstructor
public class TokenBO<T> {
    /**
     * Token 封装的对象
     */
    private T obj;

    /**
     * Token
     */
    private String token;

    public TokenBO(String token, T obj){
        this.obj = obj;
        this.token = token;
    }
}
