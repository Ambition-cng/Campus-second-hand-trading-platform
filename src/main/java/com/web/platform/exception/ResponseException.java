package com.web.platform.exception;

/**
 * @author hly
 * @Description: 错误类
 * @create 2022-05-12 19:54
 */
public class ResponseException extends RuntimeException{
    /**
     * 错误代码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    public ResponseException(String message, Integer code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public ResponseException(String message) {
        super(message);
    }
}
