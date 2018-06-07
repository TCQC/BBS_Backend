package com.tcqc.bbs.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tcqc.bbs.entity.User;
import com.tcqc.bbs.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    public String getToken(BigInteger id, String password) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(id.toString())          // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(password));   // 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException ignore) {
        }
        return token;
    }
}
