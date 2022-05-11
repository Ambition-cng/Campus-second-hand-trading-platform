package com.web.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hly
 * @Description:
 * @create 2022-05-06 21:10
 */
@SpringBootApplication
@MapperScan("com.web.platform.mapper")
public class PlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }
}
