package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Block;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockDaoTest {
    @Autowired
    BlockDao blockDao;
    @Test
    public void getBlockById() {
        BigInteger id = BigInteger.valueOf(1);
        Block block = blockDao.getBlockById(id);
        System.out.println(block);
    }
}