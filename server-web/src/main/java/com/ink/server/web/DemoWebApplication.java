package com.ink.server.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Created by carlos
 */
@SpringBootApplication(scanBasePackages = "com.ink.server")
@MapperScan("com.ink.server.dao.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }
}