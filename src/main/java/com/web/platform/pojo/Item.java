package com.web.platform.pojo;

import lombok.Data;


/**
 * @author hly
 * @Description: 二手商品实体类
 * @create 2022-05-18 20:17
 */
@Data
public class Item {

    private Integer itemid;

    private String username;

    private String uid;

    private String itemname;

    /**
     * 商品描述
     */
    private String remark;

    private String price;

    private String sort;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 图片地址
     */
    private String image;
}
