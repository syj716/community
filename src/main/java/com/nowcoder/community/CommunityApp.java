package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//会扫描所在包以及包的子包的所有bean
public class CommunityApp {
    public static void main(String[] args) {
        SpringApplication.run(CommunityApp.class,args);
    }
}
