package com.mading.cloud.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@SuppressWarnings("serial")//?
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式风格访问？
public class Dept implements Serializable {
    /**
     *  部门编码 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 数据库名称，来自哪个数据库
     */
    private String dbSource;

    public Dept(String deptName){
        super();
        this.deptName = deptName;
    }

}
