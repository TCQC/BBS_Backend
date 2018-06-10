package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoTest {
    @Autowired
    PostDao postDao;
    @Test
    public void addPost() {
        Post post = new Post();
        for (int i =0; i < 20; i++){
            post.setTitle("Test Post" + i);
            post.setContent("Test Post Content" + i);
            post.setUserId(BigInteger.ONE);
            post.setCategoryId(BigInteger.ONE);
            postDao.addPost(post);
        }
    }

    @Test
    public void changePostStatusById() {
        BigInteger id ;
        for (int i = 6; i < 60; i++){
            id = BigInteger.valueOf(i);
            postDao.changePostStatusById(id, 1);
        }
    }
}