package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface PostService {
    /**
     * 查询对应ID的post详细信息
     * @param id
     * @return
     */
    FormatResult<Post> getPostById(BigInteger id);

    /**
     * 查询某个category下的所有post
     * @param id category id
     * @param startIndex 开始
     * @param pageSize 页面大小
     * @param sortType 排序方式
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostByCategoryId(BigInteger id, int startIndex, int pageSize, String sortType);

    /**
     * 查询某个block下的所有post
     * @param blockId 版块id
     * @param startIndex 开始
     * @param pageSize 页面大小
     * @param sortType 排序方式
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostByBlockId(BigInteger blockId, int startIndex, int pageSize, String sortType);

    /**
     * 查询某个用户下的所有post
     * @param id category id
     * @param startIndex 开始
     * @param pageSize 页面大小
     * @param sortType 排序方式
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostByUserId(BigInteger id, int startIndex, int pageSize, String sortType);


    /**
     * 查询某个用户下的所有提问
     * @param id category id
     * @param startIndex 开始
     * @param pageSize 页面大小
     * @param sortType 排序方式
     * @return
     */
    FormatResult<List<PostInfo>> findQuestionByUserId(BigInteger id, int startIndex, int pageSize, String sortType);

    /**
     * 根据收藏夹ID查询
     * @param id
     * @param startIndex
     * @param pageSize
     * @param sortType
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostByFavoriteId(BigInteger id, int startIndex, int pageSize, String sortType);


    /**
     * 关键字搜索帖子
     * @param keyword
     * @param startIndex
     * @param pageSize
     * @param sortType
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostInfoByKeyword(String keyword, int startIndex, int pageSize, String sortType);

    /**
     * 添加Post
     * @param userId 用户id
     * @param categoryId 分类id
     * @param title 标题
     * @param content 内容
     * @return
     */
    FormatResult<BigInteger> addPost(BigInteger userId, BigInteger categoryId, String title, String content);


    /**
     * 更新实体
     * @param userId 用户id
     * @param categoryId 分类id
     * @param title 标题
     * @param content 内容
     * @return
     */
    FormatResult<Object>  putPost(BigInteger id, BigInteger userId, BigInteger categoryId, String title, String content);

    /**
     * 删除Post
     * @param id
     * @return
     */
    FormatResult<Object> changePostStatus(BigInteger id, int status);

    /**
     * 得到热门的帖子信息
     * @return
     */
    FormatResult<List<PostInfo>> getHotPost();

    /**
     * 得到用户帖子量，提问量，评论量
     * @param id
     * @return
     */
    FormatResult<Map<String, Object>> getNumberInfoByUserId(BigInteger id);

}
