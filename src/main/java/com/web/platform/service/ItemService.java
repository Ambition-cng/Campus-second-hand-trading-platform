package com.web.platform.service;

import com.web.platform.pojo.Item;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-18 20:32
 */
@Component
public interface ItemService {
    /**
     * 发布二手商品
     * @param item
     * @return
     */
    ResponseResult<Item> publishItem(Item item);

    /**
     * 通过 itemID 获取商品
     * @param itemId
     * @return
     */
    ResponseResult<Item> getItemById(String itemId);

    /**
     * 通过 uid 获取自己发布的商品列表
     * @param uid
     * @return
     */
    ResponseResult<List<Item>> getItemListByUid(String uid);

    /**
     * 通过 uid 获取自己求购的商品列表
     * @param uid
     * @return
     */
    ResponseResult<List<Item>> getReItemListByUid(String uid);

    /**
     * 求购商品
     * @param item
     * @return
     */
    ResponseResult<Item> requestItem(Item item);

    /**
     * 删除发布的商品
     * @param itemId
     * @return
     */
    ResponseResult<Void> deleteItem(String itemId);

    /**
     * 删除求购的商品
     * @param itemId
     * @return
     */
    ResponseResult<Void> deleteReItem(String itemId);

    /**
     * 通过分类搜索商品列表
     * @param category
     * @return
     */
    ResponseResult<List<Item>> selectItemListByCategory(String category);

    ResponseResult<List<Item>> selectItemByName(String itemName);
}
