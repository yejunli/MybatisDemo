package com.msb;

import com.msb.mapper.EmpMapper;
import com.msb.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:46}
 * @Description: Emp测试查询
 * @version:1.0
 */
public class TestEmpQuery {
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
    public void queryEmpAll(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.findAll();
        emps.forEach(System.out::println);
    }
    @Test//根据员工编号查询对应的信息
    public void queryEmpno(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        Emp emp = mapper.findByEmpno(7839);
        System.out.println(emp);
    }
    @Test
    public void queryDeptnoBySal(){
        //反射机制
        //EmpMapper mapper = sqlsession.getMapper(com.msb.mapper.EmpMapper.class);//调用Class类提供静态方法
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);//调用Class类提供静态方法
        List<Emp> emps = mapper.findByDeptnoAndSal(10, 2500.0);
        emps.forEach(System.out::println);
    }
    //模糊查询
    //查询名字中带"a"的全部信息
    @Test
    public void queryBynaem(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        List<Emp> a = mapper.findByEname("a");
        a.forEach(System.out::println);
    }
    //添加员工信息测试
    @Test
    public void insertEmp(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        mapper.addEmp(new Emp(null, "张三", "学生", 7839, new Date(), 3000.10, 300.0, 10));
        mapper.addEmp(new Emp(null, "李斯", "学生", 7839, new Date(), 3000.10, 300.0, 10));
        mapper.addEmp(new Emp(null, "汪武", "学生", 7839, new Date(), 3000.10, 300.0, 10));
        sqlsession.commit();
    }
    //修改员工信息
    @Test
    public void updateEmp(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        mapper.updateEmp(24, "李斯");
        sqlsession.commit();
    }
    @Test
    public void deleteEmp(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        mapper.deleteEmp(25);
        sqlsession.commit();

    }
    @Test
    public void deleteByEmp(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        mapper.deleteByEmp(100);
        sqlsession.commit();
    }
    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }

}
