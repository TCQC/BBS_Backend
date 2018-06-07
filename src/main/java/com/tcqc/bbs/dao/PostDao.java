package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PostDao {

//    // 添加Post
//    @Insert("")
//    int addPost(Post post);
//
//    /**
//     * 删除post
//     * @param id
//     * @return
//     */
//    @Delete("update post set status = 0 where id = #{id}")
//    int delPostById(@Param("id") BigInteger id);


    /**
     * 查看某个用户的所有PostInfo (需要添加startIndex 和 sortType参数）
     * 这里的分页默认每一页十条记录
     * 默认的第一页的startIndex为0，前台传进的是页码
     * @param id
     * @return
     */
    List<PostInfo>findAllPostInfoByUserId(@Param("id")BigInteger id, @Param("startIndex")int starIndex, @Param("pageSize")int pageSize, @Param("sortType")String sortType);


    /**
     * 查看某个分类下的Post (需要添加startIndex 和 sortType参数)
     *
     * @param id
     * @return
     */
    List<PostInfo> findAllPostInfoByCategoryId(@Param("id")BigInteger id, @Param("startIndex")int startIndex,@Param("pageSize")int pageSize, @Param("sortType")String  sortType);

    /**
     * 根据帖子Id查看某条帖子的详细信息
     */
    Post getPostById(@Param("id")BigInteger id);

//    /**
//     * 查询所有的Post (无需连表） (需要添加 page 和 sort 参数)
//     * 管理员
//     * @return
//     */
//    List<Map<String, Object>> findAll();
//
//
//    /**
//     * 删除某个用户的所有发帖
//     * 管理员用
//     * @param userId
//     * @return
//     */
//    @Update("update post set status = 0 where user_id = #{userId}")
//    int delAllPostByUserId(@Param("userId") BigInteger userId);
}
