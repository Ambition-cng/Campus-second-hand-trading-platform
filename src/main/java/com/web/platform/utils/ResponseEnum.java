package com.web.platform.utils;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-05 21:18
 */
public enum ResponseEnum {
    /**
     * 登录注册错误
     */
    USER_LOGIN_ERROR(0, "账号不存在或密码错误"),
    USER_IS_EXISTED(0, "用户已存在"),

    /**
     * 商品相关错误
     */
    ITEM_IS_NOT_EXISTED(0, "商品不存在"),
    USER_NOT_PUBLISH_ITEM(0, "用户还未发布商品"),


    SUCCESS(1, "成功"),
    FAIL(0, "失败"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
