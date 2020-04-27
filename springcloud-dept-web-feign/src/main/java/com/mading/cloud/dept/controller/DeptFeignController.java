package com.mading.cloud.dept.controller;

import com.mading.cloud.bean.Dept;
import com.mading.cloud.service.DeptFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 采用Feign封装一个service接口，然后在controller中直接调用接口，
 * 比dept-web更方便
 *
 * 客户端的服务降级
 * 1.直接在controller中对每个方法降级（方法膨胀、耦合）
 */
@RestController
public class DeptFeignController {

    @Resource
    private DeptFeignService deptFeignService;


    @HystrixCommand(fallbackMethod = "processHystrix",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept getById(@PathVariable(value = "id") Long id) {
         //try { TimeUnit.SECONDS.sleep(6); } catch (InterruptedException e){ e.printStackTrace();}

        return deptFeignService.getById(id);
    }

    @HystrixCommand
    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {

        int a = 10/0;
        List<Dept> depts = deptFeignService.list();

        return depts;

    }

    public Dept processHystrix(@PathVariable("id") Long id) {

        return new Dept().setDeptNo(id).setDeptName("服务繁忙");

    }

}
