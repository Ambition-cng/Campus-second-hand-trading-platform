package com.web.platform.mapper;

import com.web.platform.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Iterator;
import java.util.List;

/**
 * @author hly
 * @Description:
 * 对应数据表： item 表
 * 对应实体类： Item
 * @create 2022-05-18 20:21
 */
@Mapper
public interface ItemMessageMapper {

    /**
     * 发布商品
     * @param item
     * @return
     */
    int publishItem(@Param("item") Item item);

    /**
     * 建立商品用户所属关系
     * @param uid
     * @param itemId
     * @return
     */
    int insertItem(String uid, Integer itemId);

    /**
     * 通过 id 获取商品
     * @param itemId
     * @return
     */
    Item getItemById(String itemId);

    /**
     * 通过 uid 获取自己发布的商品列表
     * @param uid
     * @return
     */
    List<Item> getItemListByUid(String uid);
}
