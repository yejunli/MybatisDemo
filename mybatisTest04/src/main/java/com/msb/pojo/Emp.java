package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 10:36}
 * @Description: Emp数据库对应的类
 * @version:1.0
 */
@NoArgsConstructor//无参
@AllArgsConstructor//全参
@Data//get set
public class Emp implements Serializable {
    private Integer empno;
    private String name;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
