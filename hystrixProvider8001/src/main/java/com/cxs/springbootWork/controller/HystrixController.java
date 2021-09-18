package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/payment/hystrix/{id}")
    public String getMsgViaId(@PathVariable("id") Integer id) {
        return hystrixService.getMsgViaId(id);
    }


    @GetMapping("/payment/hystrixTimeout/{id}")
    public String getMsgOfTimeout(@PathVariable("id") Integer id) {
        return hystrixService.getMsgOfTimeout(id);
    }


    @GetMapping("/payment/hystrixTest/{id}")
    public String hystrixTest(@PathVariable("id") Integer id) {
        return hystrixService.hystrixTest(id);
    }

}
