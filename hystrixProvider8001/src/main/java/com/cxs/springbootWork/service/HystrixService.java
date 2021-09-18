package com.cxs.springbootWork.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {
    public String getMsgViaId(Integer id) {
        return "线程池："+ Thread.currentThread().getName()+" paymentInfo_OK, id: "+ id + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "errorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")
    })
    public String getMsgOfTimeout(Integer id) {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+" paymentInfo_OK, id: "+ id + "O(∩_∩)O哈哈~";
    }

    public String errorHandler(Integer id) {
        return "服务器繁忙，请稍后再试；Id： " + id;
    }

    //以下为hystrix服务熔断测试
    @HystrixCommand(fallbackMethod = "fallbackFun", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            ////当在配置时间窗口内达到此数量的失败后，进行短路。10个/10s 注意分母是10s。 默认20个/10s
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //短路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String hystrixTest(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不可为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "处理单号：" + uuid + " id" + id;
    }

    public String fallbackFun(Integer id) {
        return "服务器发生错误，稍后再试.id:" + id;
    }
}
