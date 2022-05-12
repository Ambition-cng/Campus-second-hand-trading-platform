package com.web.platform.pojo;

import lombok.Data;

/**
 * @author hly
 * @Description: 用户实体类，对应用户表 user
 * @create 2022-05-12 19:06
 */
@Data
public class User {

     /**
      * 登录账号，全局唯一，不为空
      */
     private String uid;

     /**
      * 用户昵称，全局唯一，不为空
      */
     private String username;

     /**
      * 登录密码，不为空
      */
     private String password;

     /**
      * 电话号码，不为空
      */
     private String phone;

     /**
      * 用户学号,不为空
      */
     private String stuno;

     /**
      * 性别，男 or 女，不为空
      */
     private String gender;
}
