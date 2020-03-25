package com.mading.cloud.dept.controller;

import com.mading.cloud.bean.Dept;
import com.mading.cloud.dept.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 采用Feign封装一个service接口，然后在controller中直接调用接口，
 * 比dept-web更方便
 */
@RestController
public class DeptFeignController {

    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept getById(@PathVariable(value = "id") Long id) {

        return deptFeignService.getById(id);
    }


    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {

        List<Dept> depts = deptFeignService.list();

        return depts;

    }
}
