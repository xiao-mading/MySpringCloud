package com.mading.cloud.service;

import com.mading.cloud.bean.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();


    String test();
}
