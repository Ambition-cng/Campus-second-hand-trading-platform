package com.web.platform.utils;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-05 21:18
 */
public enum ResponseEnum {
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
