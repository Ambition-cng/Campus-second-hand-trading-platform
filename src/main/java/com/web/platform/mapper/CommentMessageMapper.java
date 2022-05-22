package com.web.platform.mapper;

import com.web.platform.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMessageMapper {
    /**
     * 商品留言
     * @param comment
     * @return
     */
    int addItemComment(@Param("comment")Comment comment);

    /**
     * 求购商品留言
     * @param comment
     * @return
     */
    int addWantItemComment(@Param("comment")Comment comment);

    /**
     * 删除商品留言
     * @param commentId
     * @return
     */
    int deleteItemComment(Integer commentId);

    /**
     * 删除求购商品留言
     * @param commentId
     * @return
     */
    int deleteWantItemComment(Integer commentId);

    /**
     * 通过itemId搜索商品留言
     * @param itemId
     * @return
     */
    List<Comment> selectItemCommentById(Integer itemId);

    /**
     * 通过itemId搜索求购商品留言
     * @param itemId
     * @return
     */
    List<Comment> selectWantItemCommentById(Integer itemId);
}
