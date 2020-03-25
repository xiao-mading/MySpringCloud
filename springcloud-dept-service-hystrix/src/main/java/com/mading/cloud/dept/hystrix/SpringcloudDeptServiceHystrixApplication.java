package com.mading.cloud.dept.hystrix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker  //开启熔断机制
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.mading.cloud.dept.hystrix.Mapper")
public class SpringcloudDeptServiceHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptServiceHystrixApplication.class, args);
    }

}
