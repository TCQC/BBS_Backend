package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.Post;
import com.tcqc.bbs.entity.info.PostInfo;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

public interface PostService {
    /**
     * 查询对应ID的post详细信息
     * @param id
     * @return
     */
    FormatResult<Post> getPostById(BigInteger id);

//    FormatResult<List<PostInfo>> get
}
