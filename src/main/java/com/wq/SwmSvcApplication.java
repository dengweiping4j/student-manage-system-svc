package com.wq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wq.mapper")
public class SwmSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwmSvcApplication.class, args);
    }

}
