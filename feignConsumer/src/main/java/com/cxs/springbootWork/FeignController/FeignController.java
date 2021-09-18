package com.cxs.springbootWork.FeignController;

import com.cxs.springbootWork.FeignService.FeignService;
import com.cxs.springbootWork.entity.CommonResult;
import com.cxs.springbootWork.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private FeignService feignService;

    //使用feign我们在controller层调用自己的service层，相当于在消费者的controller层调用了服务提供者的controller层
    //相较于直接使用rest template更加符合编程习惯
    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        return feignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String getPortViaTimeOut() {
        return feignService.getPortViaTimeOut();
    }
}
