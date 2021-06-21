package com.msb.mapper;


import com.msb.pojo.Emp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:40}
 * @Description: EmpMapper接口
 * @version:1.0
 */
public interface EmpMapper2 {
    /**
     * @param emp
     * @return
     */
    List<Emp> findByCondition(Emp emp);

    List<Emp> findByCondition1(Emp emp);

    /**
     * 添加员工信息
     * @param emp 将要添加的员工信息封装为emp对象
     * @return 返回的是对Emp表格影响的行数
     */
    int insertEmp(Emp emp);

    /**
     * 更新员工信息的方法
     * @param emp 要跟新的员工信息编号
     * @return  返回的是emp表格影响的行数
     */
    int updateEmp(Emp emp);

    /**
     * practice Trim update
     * @param emp emp object
     * @return return this rows
     */
    int updateEmpTrim(Emp emp);

    /**
     * 查询多个员工信息
     * @param empnos 将多个员工编号封装为一个数组
     * @return 返回的是所查询的emp对象
     */
    List<Emp> findEmpnos1(int[] empnos);

    /**
     * 根据集合查询多个员工的信息
     * @param empnos 将多个员工编号封装为一个集合
     * @return 返回的是所查询的emp对象
     */
    List<Emp> findEmpnos2(ArrayList<Integer> empnos);


}
