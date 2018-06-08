package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface PostDao {


    /**
     * 增加帖子记录
     * @param post 传入的帖子对象，该对象要在service层封装好
     * @return 这里的返回值影响的行数，如果需要返回值的id，需要在service层自己调用该post的post.getId()方法得到
     */
    @Insert("insert into post(user_id, category_id, title, content) values(#{post.userId}, #{post.categoryId}, #{post.title}, #{post.content})")
    @Options(useGeneratedKeys = true, keyProperty = "post.id")
    int addPost(@Param("post") Post post);

    /**
     * 更新帖子记录
     * @param post 传入的帖子对象，该对象要在service层封装好
     * @return
     */
    @Update("update post set post.category_id = #{post.categoryId}, post.title = #{post.title}, post.content = #{post.content} where post.id = #{post.id}")
    int putPost(@Param("post") Post post);

    /**
     * 通过传入的status参数改变帖子的状态
     * @param id 帖子的id
     * @param status 帖子的状态编号(1 删除 2 正常 3 置顶 4 加精)
     * @return
     */
    @Update("update post set status = #{status} where id = #{id} ")
    int changePostStatusById(@Param("id") BigInteger id, @Param("status")int status);


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

    /**
     * 查询所有的Post (无需连表） (需要添加 page 和 sort 参数)
     * 管理员
     * @return
     */
    @Select("select * from post")
    List<Map<String, Object>> findAllPost();


    /**
     * 删除某个用户的所有发帖,把状态置0
     * 管理员用
     * @param userId 用户的id
     * @return  返回值为影响的记录行数
     */
    @Update("update post set status = 0 where user_id = #{userId}")
    int delAllPostByUserId(@Param("userId") BigInteger userId);
}
