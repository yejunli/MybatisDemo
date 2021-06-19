package com.msb.test;

import com.msb.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/18 - 06 - 18 - 11:12}
 * @Description: 查询测试
 * @version:1.0
 */
public class TestEmpAlterParameter {
    SqlSession sqlSession;
    //将测试方法分解
    @Before
    public void init(){//在测试方法运行前先执行此方法
        SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testSingleArg(){
        //查询单个对象
        Emp emp = sqlSession.selectOne("findByEmpno", 16);
        System.out.println(emp);

    }
    @Test
    public void testMapArg(){
        //测试map集合作为参数
        Map<String,Object> args = new HashMap<>();
        args.put("deptno",20);
        args.put("sal",1500.0);

        List<Emp> emps = sqlSession.selectList("findEmpByDeptnoAndSal", args);
        emps.forEach(System.out::println);

    }
    @Test
    public void testEmpArg(){
        //测试map集合作为参数
        Emp arg = new Emp();
        arg.setDeptno(10);
        arg.setSal(3000.0);
        List<Emp> emps = sqlSession.selectList("findEmpByDeptnoAndSal",arg);
        emps.forEach(System.out::println);

    }
    @After//在测试方法执行后执行的方法
    public void close (){
        sqlSession.close();//释放资源
    }
}
