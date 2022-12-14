package com.example.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class SpringDemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
        Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);
        logger.info("开始服务启动1");
        Assert.hasLength("", () -> "打招呼说点什么吧！");
    }

}
