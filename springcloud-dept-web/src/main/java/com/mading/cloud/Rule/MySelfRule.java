package com.mading.cloud.Rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    //使用自定义的负载均衡算法
    @Bean
    public IRule getIRule(){
        return  new MyRandRole();
    }
}
