package com.mading.cloud.dept.Mapper;


import com.mading.cloud.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeptMapper {

   boolean addDept(Dept dept);

   Dept findById(@Param("deptNo") Long id);

   List<Dept> findAll();
}
