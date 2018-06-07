package com.tcqc.bbs.dao;

import com.tcqc.bbs.entity.Reply;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface ReplyDao {
    @Select("select * from reply")
    List<Map<String, Object>> queryAll();
    Reply getReplyById(BigInteger id);
}
