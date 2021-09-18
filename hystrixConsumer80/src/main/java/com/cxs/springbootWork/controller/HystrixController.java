package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.service.HystrixServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "globalErrorHandler")
public class HystrixController {
    @Resource
    private HystrixServer hystrixServer;

    @GetMapping("/consumer/payment/hystrix/{id}")
    public String getMsgViaId(@PathVariable("id") Integer id) {
        return hystrixServer.getMsgViaId(id);
    }

    //hystrix服务降级一般用于客户端侧
//    @HystrixCommand(fallbackMethod = "errorHandler1", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "3000")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrixTimeout/{id}")
    public String getMsgOfTimeout(@PathVariable("id") Integer id) {
//        int age = 10 / 0;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hystrixServer.getMsgOfTimeout(id);
    }

    public String errorHandler1(Integer id) {
        return "客户端出错，请重试；id： " +  id;
    }

    //请注意。全局兜底方法不可带有参数
    public String globalErrorHandler() {
        return "全局方法出错 ID：";
    }
}
