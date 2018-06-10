package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import com.tcqc.bbs.util.format.FormatResult;

import java.math.BigInteger;
import java.util.List;

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
     * 查询某个用户下的所有post
     * @param id category id
     * @param startIndex 开始
     * @param pageSize 页面大小
     * @param sortType 排序方式
     * @return
     */
    FormatResult<List<PostInfo>> findAllPostByUserId(BigInteger id, int startIndex, int pageSize, String sortType);

    //    /**
//     * 添加post
//     * @param post
//     * @return 成功则返回新建的post id
//     */
//    FormatResult<BigInteger> addPost(Post post);
//

    /**
     * 删除Post
     * @param id
     * @return
     */
    FormatResult<Object> changePostStatus(BigInteger id, int status);

}
