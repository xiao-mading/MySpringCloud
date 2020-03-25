package com.mading.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer  //开启EurekaServer
@SpringBootApplication
public class SpringcloudEureka03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka03Application.class, args);
    }

}
