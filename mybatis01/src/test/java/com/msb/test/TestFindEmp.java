package com.msb.test;

import com.msb.pojo.Dept;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/18 - 06 - 18 - 11:12}
 * @Description: 查询测试
 * @version:1.0
 */
public class TestFindEmp {
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
    public void testSelectOne(){
        //查询单个对象
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);
    }
    @Test
    public void testSelectList(){
        //查询多个List集合
        List<Emp> emp = sqlSession.selectList("EmpMapper.findAll");
        emp.forEach(System.out::println);

    }
    @Test
    public void testSelectMap(){
        //查询多个Map集合
        Map<Integer,Emp > empMap = sqlSession.selectMap("findEmpMap", "EMPNO");
        Set<Integer> empnos = empMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno+":"+empMap.get(empno));
        }
    }
    @After//在测试方法执行后执行的方法
    public void close (){
        sqlSession.close();//释放资源
    }
}
