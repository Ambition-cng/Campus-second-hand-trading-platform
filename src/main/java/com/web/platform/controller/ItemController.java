package com.web.platform.controller;

import com.web.platform.pojo.Item;
import com.web.platform.service.ItemService;
import com.web.platform.utils.ResponseEnum;
import com.web.platform.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-18 20:42
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    @Qualifier("itemServiceImpl")
    private ItemService itemService;

    /**
     * 已测试上线
     * 发布商品
     * @param item
     * @return
     */
    @PostMapping("/publish")
    public ResponseResult<Item> publishItem(@RequestBody Item item){
        return itemService.publishItem(item);
    }

    /**
     * 已测试上线
     * 通过 itemId 获取商品
     * @param itemId
     * @return
     */
    @GetMapping("/getItem")
    public ResponseResult<Item> getItem(String itemId){
        return itemService.getItemById(itemId);
    }

    /**
     * 已测试上线
     * 通过 uid 获取发布商品列表
     * @param uid
     * @return
     */
    @GetMapping("/getItemList")
    public ResponseResult<List<Item>> getItemList(String uid){
        return itemService.getItemListByUid(uid);
    }

    /**
     * 已测试上线
     * 发布求购商品
     * @param item
     * @return
     */
    @PostMapping("/request")
    public ResponseResult<Item> requestItem(@RequestBody Item item){
        return itemService.requestItem(item);
    }

    /**
     * 已测试上线
     * 通过 uid 获取求购商品列表
     * @param uid
     * @return
     */
    @GetMapping("/getReItemList")
    public ResponseResult<List<Item>> getReItemList(String uid){
        return itemService.getReItemListByUid(uid);
    }

    /**
     * 已测试上线
     * 删除发布的商品
     * @param itemId
     * @return
     */
    @DeleteMapping("/deleteItem")
    public ResponseResult<Void> deleteItem(String itemId){
        return itemService.deleteItem(itemId);
    }

    /**
     * 已测试上线
     * 删除求购的商品
     * @param itemId
     * @return
     */
    @DeleteMapping("/deleteReItem")
    public ResponseResult<Void> deleteReItem(String itemId){
        return itemService.deleteReItem(itemId);
    }

    /**
     * 已测试上线
     * 通过分类搜索商品
     * @param category
     * @return
     */
    @GetMapping("/getItemByCategory")
    public ResponseResult<List<Item>> selectItemListByCategory(String category){
        return itemService.selectItemListByCategory(category);
    }

    /**
     * 已测试上线
     * 通过商品名搜索商品
     * @param itemName
     * @return
     */
    @GetMapping("/getItemByName")
    public ResponseResult<List<Item>> selectItemByName(String itemName){
        return itemService.selectItemByName(itemName);
    }

}
