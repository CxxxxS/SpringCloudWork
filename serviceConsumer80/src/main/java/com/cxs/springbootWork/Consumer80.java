package com.cxs.springbootWork;

import com.cxs.MyRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SERVICEPROVIDER", configuration = MyRule.class)
public class Consumer80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80.class, args);
    }
}
