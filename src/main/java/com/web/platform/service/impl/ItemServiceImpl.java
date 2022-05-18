package com.web.platform.service.impl;

import com.web.platform.mapper.ItemMessageMapper;
import com.web.platform.pojo.Item;
import com.web.platform.service.ItemService;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
