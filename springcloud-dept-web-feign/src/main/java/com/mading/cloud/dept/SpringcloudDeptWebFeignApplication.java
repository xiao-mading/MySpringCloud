package com.mading.cloud.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableFeignClients("com.mading.cloud")
@SpringBootApplication
@ComponentScan("com.mading.cloud")
public class SpringcloudDeptWebFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptWebFeignApplication.class, args);
    }

}
