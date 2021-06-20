package com.msb;

import com.msb.mapper.EmpMapper;
import com.msb.mapper.EmpMapper2;
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
import java.util.Date;
import java.util.List;

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
    public void testFindEmp(){
        EmpMapper2 mapper = sqlsession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("SMITH");
        List<Emp> emps = mapper.findByCondition(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }


    }
    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }

}
