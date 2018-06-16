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
     * 删除用户所有的帖子
     */
    @Update("update post set status = #{status} where user_id = #{userId} ")
    int changeAllPostStatusByUserId(@Param("userId") BigInteger userId, @Param("status")int status);



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
     * 查询某block下所有帖子信息
     * @param id
     * @param startIndex
     * @param pageSize
     * @param sortType
     * @return
     */
    List<PostInfo> findAllPostInfoByBlockId(@Param("id")BigInteger id, @Param("startIndex")int startIndex,@Param("pageSize")int pageSize, @Param("sortType")String  sortType);

    /**
     * 根据收藏夹ID查询帖子信息
     * @param id
     * @param startIndex
     * @param pageSize
     * @param sortType
     * @return
     */
    List<PostInfo> findAllPostInfoByFavoriteId(@Param("id")BigInteger id, @Param("startIndex")int startIndex,@Param("pageSize")int pageSize, @Param("sortType")String  sortType);

    /**
     * 根据帖子Id查看某条帖子的详细信息
     */
    Post getPostById(@Param("id")BigInteger id);

    /**
     * 查询所有的Post (无需连表） (需要添加 page 和 sort 参数)
     * 管理员
     * @return
     */
    @Select("select * from post limit #{startIndex}, #{pageSize} ")
    List<Map<String, Object>> findAll(@Param("startIndex") int  startIndex, @Param("pageSize") int pageSize);


    /**
     * 删除某个用户的所有发帖,把状态置0
     * 管理员用
     * @param userId 用户的id
     * @return  返回值为影响的记录行数
     */
    @Update("update post set status = 0 where user_id = #{userId}")
    int delAllPostByUserId(@Param("userId") BigInteger userId);

    /**
     * 获得Post总数
     * @return
     */
    @Select("select count(id) from post where status = 1")
    int getPostSum();

    /**
     * 得到热门帖子的信息
     * @return
     */
    @Select("select p.id id, p.title title, p.status status from post p where (p.status = 2 or p.status = 3)")
    List<PostInfo> getHotPost();

    /**
     * 查看某个用户所有的提问的帖子
     * @param id 用户id
     * @param starIndex 页码
     * @param pageSize 每页的大小
     * @return 提问的帖子信息列表
     */
    List<PostInfo>findQuestionByUserId(@Param("id")BigInteger id,@Param("startIndex")int starIndex, @Param("pageSize")int pageSize,@Param("sortType") String sortType);

    /**
     * 得到用户的发帖数量，提问数量，评论量等信息
     * @param id
     * @return
     */
    @Select(" select postSum, questionSum, commentSum from\n" +
            "  (select count(id) postSum from post where user_id = #{id} and category_id != 1 and status != 0) postSum,\n" +
            "  (select count(id) questionSum from post where user_id = #{id} and category_id = 1 and status != 0)questionSum,\n" +
            "  (select count(id) commentSum from comment where user_id = #{id} and status = 1) commentSum;")
    Map<String, Object> getNumberInfoByUserId(@Param("id") BigInteger id);
}
