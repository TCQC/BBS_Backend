package com.tcqc.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tcqc.bbs.dao")
public class BbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }
}
