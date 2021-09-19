package com.cxs.springbootWork.controller;

import com.cxs.springbootWork.MyLB.LoaderBalancer;
import com.cxs.springbootWork.entity.CommonResult;
import com.cxs.springbootWork.entity.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoaderBalancer loaderBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://localhost:8001";

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/paymentEntity/get/{id}")
    public CommonResult<Payment> getPaymentById1(@PathVariable("id") long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "查询出错");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLoadBalancer(){

        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICEPROVIDER");

        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loaderBalancer.instances(instances);
        //所调用服务的url
        URI uri = serviceInstance.getUri();

        //此处调用的服务返回值是所调用服务的port
        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

    /**
     * 测试链路监控
     */
    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin", String.class);
        return result;
    }

}
