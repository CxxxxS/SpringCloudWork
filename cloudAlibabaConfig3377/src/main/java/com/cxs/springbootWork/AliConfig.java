package com.cxs.springbootWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AliConfig {
    public static void main(String[] args) {
        SpringApplication.run(AliConfig.class, args);
    }
}
