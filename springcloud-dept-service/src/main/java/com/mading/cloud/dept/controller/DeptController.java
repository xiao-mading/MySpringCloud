package com.mading.cloud.dept.controller;


import com.mading.cloud.bean.Dept;
import com.mading.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return deptService.test();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {

        if (dept != null) {

            return deptService.addDept(dept);
        }
        return false;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept getById(@PathVariable("id") Long id) {

        if (id != null) {

            Dept dept = deptService.findById(id);

            if (dept == null) {

                return new Dept().setDeptName("该用户不存在");
            }

            return dept;
        }
        return null;
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {


        List<Dept> depts = deptService.findAll();

        return depts;

    }


    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices(); //微服务的列表
        System.out.println("**********" + list);

        //在列表中找到这个微服务
        List<ServiceInstance> srvList = client.getInstances("MYSPRINGCLOUD-DEPT-8001");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
