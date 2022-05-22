package com.web.platform.service.impl;

import com.web.platform.mapper.CommentMessageMapper;
import com.web.platform.pojo.Comment;
import com.web.platform.service.CommentService;
import com.web.platform.utils.ResponseEnum;
import com.web.platform.utils.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMessageMapper commentMessageMapper;

    @Override
    public ResponseResult<Comment> commentItem(Comment comment) {
        int i = commentMessageMapper.addItemComment(comment);
        if(i>0){
            return ResponseResult.ok(comment);
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Comment> commentWantItem(Comment comment) {
        int i = commentMessageMapper.addWantItemComment(comment);
        if(i>0){
            return ResponseResult.ok(comment);
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> deleteItemComment(Integer commentId) {
        int i = commentMessageMapper.deleteItemComment(commentId);
        if(i>0){
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> deleteWantItemComment(Integer commentId) {
        int i = commentMessageMapper.deleteWantItemComment(commentId);
        if(i>0){
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<List<Comment>> getItemCommentById(Integer itemId) {
        List<Comment> commentList = commentMessageMapper.selectItemCommentById(itemId);
        if (commentList.size() == 0){
            return ResponseResult.fail(ResponseEnum.USER_NOT_PUBLISH_ITEM.getCode(), ResponseEnum.USER_NOT_PUBLISH_ITEM.getMsg());
        }else{
            return ResponseResult.ok(commentList);
        }
    }

    @Override
    public ResponseResult<List<Comment>> getWantItemCommentById(Integer itemId) {
        List<Comment> commentList = commentMessageMapper.selectWantItemCommentById(itemId);
        if (commentList.size() == 0){
            return ResponseResult.fail(ResponseEnum.USER_NOT_PUBLISH_ITEM.getCode(), ResponseEnum.USER_NOT_PUBLISH_ITEM.getMsg());
        }else{
            return ResponseResult.ok(commentList);
        }
    }
}
