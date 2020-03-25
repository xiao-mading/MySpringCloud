package com.mading.cloud.dept.service.impl;

import com.mading.cloud.bean.Dept;
import com.mading.cloud.dept.Mapper.DeptMapper;
import com.mading.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;



    @Override
    public boolean addDept(Dept dept) {

        boolean success = deptMapper.addDept(dept);
        return success;
    }

    @Override
    public Dept findById(Long id) {

        Dept dept = deptMapper.findById(id);
        return dept;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = deptMapper.findAll();
        return depts;
    }



    @Override
    public String test() {
        return "success";
    }

}
