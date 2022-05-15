package com.web.platform.mapper;

import com.web.platform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hly
 * @Description:
 * 对应数据库： user
 * 对应实体类： User
 * @create 2022-05-12 19:39
 */
@Mapper
public interface UserMessageMapper {

    /**
     * 创建用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

    /**
     * 通过 uid 获取用户
     * @param uid
     * @return
     */
    User getUserByUid(String uid);

    /**
     * 通过 uid and password 获取用户
     * @param uid
     * @param password
     * @return
     */
    User getUser(String uid, String password);
}
