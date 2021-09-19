package com.cxs.springbootWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AliProvider9002 {
    public static void main(String[] args) {
        SpringApplication.run(AliProvider9002.class, args);
    }
}
