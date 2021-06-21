package com.msb;

import com.msb.mapper.EmpMapper2;
import com.msb.pojo.Emp;
import jdk.nashorn.internal.ir.EmptyNode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:46}
 * @Description: Emp测试查询
 * @version:1.0
 */
public class TestEmpFind {
    SqlSession sqlsession;
    @Before
    public void into (){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = ssfb.build(resourceAsStream);
        sqlsession = build.openSession();

    }
    @Test
    public void testFindEmp() throws ParseException {
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("S");
        //emp.setEmpno(7839);
        //emp.setHiredate(new SimpleDateFormat("yyyy/MM/dd").parse("1981/05/01"));//按照日期查询
        List<Emp> emps = mapper.findByCondition(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }


    }
    @Test
    public void testFindByEmp() throws ParseException {
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        //emp.setEname("S");
        //emp.setEmpno(7839);
        emp.setHiredate(new SimpleDateFormat("yyyy/MM/dd").parse("1981/05/01"));//按照日期查询
        List<Emp> emps = mapper.findByCondition1(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }

    }
    @Test
    public void insertEmp(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp(null,"zhangsan","taijian",7839,new Date(),3600.1,300.1,10 );
        mapper.insertEmp(emp);
        sqlsession.commit();
    }
    @Test
    public void updateEmp(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7935);
        emp.setEname("wagnfei");
        emp.setSal(4000.0);
        mapper.updateEmp(emp);
        sqlsession.commit();
    }
    @Test
    public void updateEmpTrim(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7935);
        emp.setEname("朱重八");
        emp.setJob("皇帝");
        mapper.updateEmp(emp);
        sqlsession.commit();
    }
    @Test
    public void findEmps(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        List<Emp> empnos1 = mapper.findEmpnos1(new int[]{7839,7788});
        empnos1.forEach(System.out::println);

    }
    @Test
    public void findEmpsList(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        ArrayList<Integer> empnos = new ArrayList<>();
        Collections.addAll(empnos,7788,7839);
        List<Emp> empnos2 = mapper.findEmpnos2(empnos);
        empnos2.forEach(System.out::println);
    }
    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }

}
