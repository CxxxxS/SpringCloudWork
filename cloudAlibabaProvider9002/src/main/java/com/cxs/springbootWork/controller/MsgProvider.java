package com.cxs.springbootWork.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgProvider {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/{id}")
    public String getMsg(@PathVariable("id") Integer id) {
        return "now nacos is working, port: " + port;
    }
}
