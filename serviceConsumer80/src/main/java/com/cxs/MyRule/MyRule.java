package com.cxs.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();

        //定义为随机规则：new RoundRobinRule()
        //定义为重置策略：new RetryRule();
    }
}
