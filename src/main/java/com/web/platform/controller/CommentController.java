package com.web.platform.controller;

import com.web.platform.pojo.Comment;
import com.web.platform.service.CommentService;
import com.web.platform.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    @Qualifier("commentServiceImpl")
    private CommentService commentService;

    /**
     * 添加商品留言
     * @param comment
     * @return
     */
    @PostMapping("/item")
    public ResponseResult<Comment> commentItem(@RequestBody Comment comment){
        return commentService.commentItem(comment);
    }

    /**
     * 添加求购商品留言
     * @param comment
     * @return
     */
    @PostMapping("/wantItem")
    public ResponseResult<Comment> commentWantItem(@RequestBody Comment comment){
        return commentService.commentWantItem(comment);
    }

    /**
     * 删除商品留言
     * @param commentId
     * @return
     */
    @DeleteMapping("/deleteItemComment")
    public ResponseResult<Void> deleteItemComment(Integer commentId){
        return commentService.deleteItemComment(commentId);
    }

    /**
     * 删除求购商品留言
     * @param commentId
     * @return
     */
    @DeleteMapping("/deleteWantItemComment")
    public ResponseResult<Void> deleteWantItemComment(Integer commentId){
        return commentService.deleteWantItemComment(commentId);
    }

    /**
     * 获取商品留言
     * @param itemId
     * @return
     */
    @GetMapping("/getItemCommentById")
    public ResponseResult<List<Comment>> getItemCommentById(Integer itemId){
        return commentService.getItemCommentById(itemId);
    }

    /**
     * 获取求购商品留言
     * @param itemId
     * @return
     */
    @GetMapping("/getWantItemCommentById")
    public ResponseResult<List<Comment>> getWantItemCommentById(Integer itemId){
        return commentService.getWantItemCommentById(itemId);
    }

}
