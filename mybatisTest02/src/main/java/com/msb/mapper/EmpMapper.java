package com.msb.mapper;


import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import com.sun.org.apache.xml.internal.dtm.ref.ExpandedNameTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:40}
 * @Description: EmpMapper接口
 * @version:1.0
 */
public interface EmpMapper {
    /**
     * 查询全部员工信息
     * @return 返回的是Emp对象的集合
     */
    List<Emp> findAll();

    /**
     * 根据工号查询对应的员工信息
     * @param empno job number
     * @return 要查询的员工信息
     */
    Emp findByEmpno(int empno);

    /**
     * 根据部门编号查询低于给定值的工资的员工信息
     * @param deptno 部门编号
     * @param sal 查询低于该值的工资的员工信息
     * @return 返回的所对应的员工信息
     */
    List<Emp> findByDeptnoAndSal(int deptno,double sal);

    /**
     * 模糊查询:
     * 根据给出的字母查询姓名中包含的字母
     * @param name 给出的字母
     * @return 返回的是查询到的名字的集合
     */
    List<Emp> findByEname(String name);

    /**
     * 增加员工信息的方法
     * @param emp 增加员工的信息所封装的emp对象
     * @return 对数据库产生影响的行数
     */
    int addEmp(Emp emp);

    /**
     * 修改员工信息
     * @param empno 要修改的员工信息的编号
     * @param ename 要修改的员工姓名
     * @return 对数据库产生影响的行数
     */
    int updateEmp(@Param("empno")int empno,@Param("ename") String ename);

    /**
     * 删除员工信息
     * @param empno 要删除的员工编号
     * @return 对数据库产生影响的行数
     */
    int deleteEmp(int empno);

    /**
     * 给出一个指定的数,删除大于它的员工编号
     * @return 对数据库产生影响的行数
     */
    int deleteByEmp(int number);



}
