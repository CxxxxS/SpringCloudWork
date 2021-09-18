package com.cxs.springbootWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer80.class, args);
    }
}
