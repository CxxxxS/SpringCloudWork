package com.cxs.springbootWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamController {
    public static void main(String[] args) {
        SpringApplication.run(StreamController.class, args);
    }
}
