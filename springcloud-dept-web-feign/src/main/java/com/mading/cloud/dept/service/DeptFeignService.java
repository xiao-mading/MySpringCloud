package com.mading.cloud.dept.service;

import com.mading.cloud.bean.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(value = "SPRINGCLOUD-DEPT")
public interface DeptFeignService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept getById(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Dept> list();
}
