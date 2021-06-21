package com.msb.test;

import com.msb.mapper.EmpMapper;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/21 - 06 - 21 - 19:03}
 * @Description: 查询测试
 * @version:1.0
 */
public class FindTest  {
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
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        List<Emp> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }
}
