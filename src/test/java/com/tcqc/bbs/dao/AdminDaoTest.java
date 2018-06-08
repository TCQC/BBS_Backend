package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {
    @Autowired
    AdminDao adminDao;
    @Test
    public void getUserInfoByUsernameAndPassword() {
        Admin admin = adminDao.getUserInfoByUsernameAndPassword("tuanzi", "123456");
        System.out.println(admin);
    }
}