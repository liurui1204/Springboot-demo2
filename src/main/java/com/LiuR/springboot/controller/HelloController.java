package com.LiuR.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Auther 刘瑞
 * @create 2022-01-16
 */
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello(@RequestParam("username") String name){
        log.info("请求进来了。。。");
        return "Hello,Spring Boot 2！" + "你好:" + name;
    }

}
