package com.cxs.springbootWork.FeignService;

import com.cxs.springbootWork.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SERVICEPROVIDER")
public interface FeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/timeout")
    public String getPortViaTimeOut();
}
