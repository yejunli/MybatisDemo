package com.msb.mapper;

import com.msb.pojo.Emp;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:40}
 * @Description: EmpMapper接口
 * @version:1.0
 */
public interface EmpMapper {
    /**
     * 将dept表格作为emp的属性进行封装成一个新的emp表格
     * @param empno 要查询的员工编号
     * @return emp对象,组合了dept表格的属性,对部门信息进行存储
     */
    Emp findEmpJoinDeptByDeptno(int empno);
}
