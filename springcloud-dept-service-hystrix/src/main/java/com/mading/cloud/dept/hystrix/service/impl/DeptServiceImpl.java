package com.mading.cloud.dept.hystrix.service.impl;

import com.mading.cloud.bean.Dept;
import com.mading.cloud.dept.hystrix.mapper.DeptMapper;
import com.mading.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * 服务端的服务降级
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;



    @Override
    public boolean addDept(Dept dept) {

        boolean success = deptMapper.addDept(dept);
        return success;
    }


      /* @HystrixCommand(fallbackMethod = "processHystrix",commandProperties =
             {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})*/ //毫秒级的时间超时

    @HystrixCommand(fallbackMethod = "processHystrix", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //10秒内，触发断路器的最少请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //拒绝请请求到再次尝试打开
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少后跳闸，默认50%
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    }) //熔断机制
    @Override
    public Dept findById(Long id) {

        Dept dept = deptMapper.findById(id);

        if (dept==null){

            throw  new RuntimeException("用户为空");
        }
        System.out.println("8004服务调用成功");
        System.out.println(dept);
        return dept;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = deptMapper.findAll();
        System.out.println("8004服务被调用");
        return depts;
    }



    @Override
    public String test() {
        return "success";
    }

    public Dept processHystrix(@PathVariable("id") Long id) {

        Dept dept = new Dept().setDeptNo(id)
                              .setDeptName("用户不存在")
                              .setDbSource("数据库中没有对应信息");
        System.out.println(dept);
        return dept;
    }

}
