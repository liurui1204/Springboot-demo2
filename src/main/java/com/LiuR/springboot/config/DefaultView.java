package com.LiuR.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Auther 刘瑞
 * @create 2022-01-16
 */
@Configuration
public class DefaultView implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        System.out.println(123);
        registry.addViewController("/springboot").setViewName("forward:index");
        registry.addStatusController("/error/404", HttpStatus.NOT_FOUND);
        registry.addStatusController("/error/error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
