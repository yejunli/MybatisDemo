package test;

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

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/21 - 06 - 21 - 19:03}
 * @Description: 查询测试
 * @version:1.0
 */
public class FindTest {
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
    public void findEmpJoinDepnByEmpno(){
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        Emp emp = mapper.findEmpJoinDeptByDeptno(7839);
        System.out.println(emp);

    }

    @After
    public void close(){
        sqlsession.close();//close sqlSession
    }
}
