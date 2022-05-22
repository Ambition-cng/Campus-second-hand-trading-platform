package com.web.platform.pojo;

import lombok.Data;

@Data
public class Comment {
    private Integer commentid;
    private Integer itemid;
    /*
     *留言内容，json 字符串格式，包含有留言时间(time)、留言用户 昵称(username)、留言内容(msg)
     */
    private String  content;
}
