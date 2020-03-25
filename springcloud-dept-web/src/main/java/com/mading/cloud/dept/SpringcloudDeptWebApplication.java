package com.mading.cloud.dept;

import com.mading.cloud.Rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@RibbonClient(name="SPRINGCLOUD-DEPT",configuration= MySelfRule.class)//启动时，加载该配置类
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudDeptWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptWebApplication.class, args);
    }

}
