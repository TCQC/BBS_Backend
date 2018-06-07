package com.tcqc.bbs.service;

import com.tcqc.bbs.entity.User;

import java.math.BigInteger;

/**
 * token生成
 */
public interface AuthenticationService {
    String getToken(BigInteger id, String password);

}
