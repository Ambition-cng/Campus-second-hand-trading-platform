package com.web.platform.mapper;

import com.web.platform.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过 uid 获取自己求购的商品列表
     * @param uid
     * @return
     */
    List<Item> getReItemListByUid(String uid);

    /**
     * 发布求购商品
     * @param item
     * @return
     */
    int requestItem(@Param("item") Item item);

    /**
     * 建立求购商品用户所属关系
     * @param uid
     * @param itemId
     * @return
     */
    int insertReItem(String uid, Integer itemId);

    /**
     * 下架发布的商品
     * @param itemId
     * @return
     */
    int deleteItem(String itemId);

    /**
     * 下架求购的商品
     * @param itemId
     * @return
     */
    int deleteReItem(String itemId);

    /**
     * 删除用户与发布商品的联系
     * @param itemId
     * @return
     */
    int removeItem(String itemId);

    /**
     * 删除用户与求购商品的联系
     * @param itemId
     * @return
     */
    int removeReItem(String itemId);

    /**
     * 通过分类搜索商品
     * @param category
     * @return
     */
    List<Item> selectItemByCategory(String category);

    /**
     * 通过名字搜索商品
     * @param itemName
     * @return
     */
    List<Item> selectItemByName(String itemName);
}
