package com.web.platform.controller;

import com.web.platform.pojo.Item;
import com.web.platform.service.ItemService;
import com.web.platform.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
