package com.cxs.springbootWork.MyLB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoaderBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
