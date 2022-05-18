package com.web.platform.service;

import com.web.platform.pojo.Item;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Component;

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
}
