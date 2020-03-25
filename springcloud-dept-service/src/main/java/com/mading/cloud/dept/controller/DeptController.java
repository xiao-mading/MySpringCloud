package com.mading.cloud.dept.controller;


import com.mading.cloud.bean.Dept;
import com.mading.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

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
            return dept;
        }
        return null;
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {

        List<Dept> depts = deptService.findAll();

        return depts;

    }

}
