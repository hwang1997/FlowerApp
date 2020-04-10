package com.mis.flowers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mis.flowers.dao")
public class FlowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerApplication.class, args);
    }

}
