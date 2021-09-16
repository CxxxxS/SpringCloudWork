package com.cxs.springbootWork.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ServerProvider {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String consul() {
        return "port of consul:" + serverPort + UUID.randomUUID().toString();
    }
}
