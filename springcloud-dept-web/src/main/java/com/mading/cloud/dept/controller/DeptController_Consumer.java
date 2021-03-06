package com.mading.cloud.dept.controller;


import com.mading.cloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 基于RestTemplate  + Ribbon
 *
 * 使用了Feign则不使用这种方式了
 *
 * 调用服务：http://localhost/consumer/dept/list
 */
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){

        Boolean success = restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return success;
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept getById(@PathVariable Long id){

        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id,Dept.class);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){

        List<Dept> depts = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return depts;
    }


    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }



}
