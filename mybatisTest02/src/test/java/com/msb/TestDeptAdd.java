package com.msb;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Arg;
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

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:46}
 * @Description: Emp测试查询
 * @version:1.0
 */
public class TestDeptAdd {
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
    public void testAddDept(){
        DeptMapper mapper = sqlsession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"英语老师","WuHan");
        int i = mapper.addDept(dept);
        System.out.println(i);
        sqlsession.commit();//提交事务
        System.out.println(dept.getDeptno());
    }
    @Test//测试二
    public void testAddDept2(){
        DeptMapper mapper = sqlsession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"数学老师","WuHan");
        int i = mapper.addDept2(dept);
        System.out.println(i);
        sqlsession.commit();//提交事务
        System.out.println(dept.getDeptno());
    }
    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }

}
