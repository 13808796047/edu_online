package com.summer.service.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Summer
 * @date 2022/3/16 1:41
 */
@SpringBootApplication
@MapperScan("com.summer.service.edu.mapper")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
