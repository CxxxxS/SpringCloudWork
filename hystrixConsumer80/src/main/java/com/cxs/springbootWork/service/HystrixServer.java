package com.cxs.springbootWork.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = HystrixFallbackService.class)
public interface HystrixServer {
    @GetMapping("/payment/hystrix/{id}")
    public String getMsgViaId(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrixTimeout/{id}")
    public String getMsgOfTimeout(@PathVariable("id") Integer id);
}
