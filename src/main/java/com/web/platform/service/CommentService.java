package com.web.platform.service;

import com.web.platform.pojo.Comment;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentService {
    /**
     * 商品留言
     * @param comment
     * @return
     */
    ResponseResult<Comment> commentItem(Comment comment);

    /**
     * 求购商品留言
     * @param comment
     * @return
     */
    ResponseResult<Comment> commentWantItem(Comment comment);

    /**
     * 删除商品留言
     * @param commentId
     * @return
     */
    ResponseResult<Void> deleteItemComment(Integer commentId);

    /**
     * 删除求购商品留言
     * @param commentId
     * @return
     */
    ResponseResult<Void> deleteWantItemComment(Integer commentId);

    /**
     * 通过itemId搜索商品留言
     * @param itemId
     * @return
     */
    ResponseResult<List<Comment>> getItemCommentById(Integer itemId);

    /**
     * 通过itemId搜索求购商品留言
     * @param itemId
     * @return
     */
    ResponseResult<List<Comment>> getWantItemCommentById(Integer itemId);
}
