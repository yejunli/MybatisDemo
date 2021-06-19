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
import java.util.Date;


/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/18 - 06 - 18 - 11:12}
 * @Description: 查询测试
 * @version:1.0
 */
public class TestEmpInsert {
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
        sqlSession = factory.openSession(true);//加true设置自动提交事务
    }
    @Test
    public void empInsert() {
        Emp emp = new Emp(null, "张三", "程序员", 7839, new Date(), 3458.0, 300.0,30);
        int addEmp = sqlSession.insert("empInsert", emp);
        System.out.println(addEmp);
        //手动提交事务
        //sqlSession.commit();
        /*
        * Mybatis默认不进行提交事务
        * 需要手动提交事务
        * sqlSession.commit();
        * 也可以设置自动提交事务
        * 将:sqlSession = factory.openSession(true);设置为true
        *
        * */
    }
    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp();
        emp.setEname("刘强东");
        emp.setEmpno(18);
        int rows = sqlSession.update("updateEmp", emp);
        System.out.println(rows);
    }

    //delete data with Empno less than 1000
    @Test
    public void testDeleteEmp(){
        int rows = sqlSession.delete("deleteEmp", "1000");
        System.out.println(rows);
    }
    @After//在测试方法执行后执行的方法
    public void close (){
        sqlSession.close();//释放资源
    }

}
