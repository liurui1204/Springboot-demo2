package com.LiuR.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Auther 刘瑞
 * @create 2022-01-16
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
