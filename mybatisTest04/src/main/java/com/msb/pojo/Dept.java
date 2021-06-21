package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/18 - 06 - 18 - 10:45}
 * @Description: 数据库表格Dept对应的类
 * @version:1.0
 */
@Data//利用lombok生成Get Set方法
@AllArgsConstructor//利用lombok生成全参构造方法
@NoArgsConstructor//利用lombok生成无参构造方法
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

}
