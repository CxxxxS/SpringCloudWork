package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.entity.CommonResult;
import com.cxs.springbootWork.entity.Payment;
import com.cxs.springbootWork.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);

        if (i > 0) {
            return new CommonResult(200, "插入成功", i);
        }else {
            return new CommonResult(404, "插入失败", null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功" + port, payment);
        }else {
            return new CommonResult(404, "未查询到任何结果", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object getServiceInfo() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instanceList = discoveryClient.getInstances("serviceProvider");

        for (ServiceInstance instance : instanceList) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping("/payment/timeout")
    public String getPortViaTimeOut() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
