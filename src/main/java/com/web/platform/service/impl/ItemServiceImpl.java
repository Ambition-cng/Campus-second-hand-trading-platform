package com.web.platform.service.impl;

import com.web.platform.mapper.ItemMessageMapper;
import com.web.platform.pojo.Item;
import com.web.platform.service.ItemService;
import com.web.platform.utils.ResponseEnum;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hly
 * @Description: TODO
 * @create 2022-05-18 20:33
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMessageMapper itemMessageMapper;

    @Override
    public ResponseResult<Item> publishItem(Item item) {
        int r = itemMessageMapper.publishItem(item);
        int s = itemMessageMapper.insertItem(item.getUid(), item.getItemid());
        if(r > 0 && s > 0){
            return ResponseResult.ok(item);
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Item> getItemById(String itemId) {
        Item item = itemMessageMapper.getItemById(itemId);
        if (item == null){
            return ResponseResult.fail(ResponseEnum.ITEM_IS_NOT_EXISTED.getCode(), ResponseEnum.ITEM_IS_NOT_EXISTED.getMsg());
        }else{
            return ResponseResult.ok(item);
        }
    }

    @Override
    public ResponseResult<List<Item>> getItemListByUid(String uid) {
        List<Item> itemList = itemMessageMapper.getItemListByUid(uid);

        if (itemList.size() == 0){
            return ResponseResult.fail(ResponseEnum.USER_NOT_PUBLISH_ITEM.getCode(), ResponseEnum.USER_NOT_PUBLISH_ITEM.getMsg());
        }else{
            return ResponseResult.ok(itemList);
        }
    }

    @Override
    public ResponseResult<List<Item>> getReItemListByUid(String uid) {
        List<Item> itemList = itemMessageMapper.getReItemListByUid(uid);
        if (itemList.size() == 0){
            return ResponseResult.fail(ResponseEnum.USER_NOT_REQUEST_ITEM.getCode(), ResponseEnum.USER_NOT_REQUEST_ITEM.getMsg());
        }else{
            return ResponseResult.ok(itemList);
        }
    }

    @Override
    public ResponseResult<Item> requestItem(Item item) {
        int r = itemMessageMapper.requestItem(item);
        int s = itemMessageMapper.insertReItem(item.getUid(), item.getItemid());
        if(r > 0 && s > 0){
            return ResponseResult.ok(item);
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> deleteItem(String itemId) {
        int r = itemMessageMapper.deleteItem(itemId);
        int s = itemMessageMapper.removeItem(itemId);
        if(r > 0){
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> deleteReItem(String itemId) {
        int r = itemMessageMapper.deleteReItem(itemId);
        int s = itemMessageMapper.removeReItem(itemId);
        if(r > 0){
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<List<Item>> selectItemListByCategory(String category) {
        List<Item> itemList = itemMessageMapper.selectItemByCategory(category);
        if (itemList.size() == 0){
            return ResponseResult.fail(ResponseEnum.CATEGORY_OF_ITEM_IS_NOT_EXISTED.getCode(), ResponseEnum.CATEGORY_OF_ITEM_IS_NOT_EXISTED.getMsg());
        }else{
            return ResponseResult.ok(itemList);
        }
    }

    @Override
    public ResponseResult<List<Item>> selectItemByName(String itemName) {
        List<Item> itemList = itemMessageMapper.selectItemByName(itemName);
        if (itemList.size() == 0){
            return ResponseResult.fail(ResponseEnum.ITEM_IS_NOT_EXISTED.getCode(), ResponseEnum.ITEM_IS_NOT_EXISTED.getMsg());
        }else{
            return ResponseResult.ok(itemList);
        }
    }
}
