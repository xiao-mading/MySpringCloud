package com.mading.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient   //启动服务发现
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.mading.cloud.dept.Mapper")
public class SpringcloudDeptServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptServiceApplication.class, args);
    }

}
