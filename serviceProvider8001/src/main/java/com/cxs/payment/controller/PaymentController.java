package com.cxs.payment.controller;

import com.cxs.payment.entity.CommonResult;
import com.cxs.payment.entity.Payment;
import com.cxs.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
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
            return new CommonResult(200, "查询成功", payment);
        }else {
            return new CommonResult(404, "未查询到任何结果", null);
        }
    }

}
