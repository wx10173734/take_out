package com.lzc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @title: TakeOutApplication
 * @Author luozouchen
 * @Date: 2023/3/11 12:49
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement//开启事务注解支持
public class TakeOutApplication {
    public static void main(String[] args) {
        SpringApplication.run(TakeOutApplication.class, args);
        log.info("项目启动成功...");
    }
}
