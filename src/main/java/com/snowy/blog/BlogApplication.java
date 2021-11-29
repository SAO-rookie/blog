package com.snowy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author snowy
 * @date 2021/11/22 21:48
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.snowy.blog.mapper"})
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }
}
