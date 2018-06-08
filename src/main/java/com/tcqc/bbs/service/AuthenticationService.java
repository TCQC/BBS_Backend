package com.tcqc.bbs.service;

import java.math.BigInteger;

/**
 * token生成
 */
public interface AuthenticationService {
    /**
     * 根据id 和密码生成token
     * @param id
     * @param password
     * @return
     */
    String getToken(BigInteger id, String password);
}
