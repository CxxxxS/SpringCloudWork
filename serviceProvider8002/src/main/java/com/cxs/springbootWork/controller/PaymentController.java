package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.entity.CommonResult;
import com.cxs.springbootWork.entity.Payment;
import com.cxs.springbootWork.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
