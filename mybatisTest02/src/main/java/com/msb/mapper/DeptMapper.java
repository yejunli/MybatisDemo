package com.msb.mapper;

import com.msb.pojo.Dept;
import org.apache.ibatis.jdbc.Null;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/20 - 06 - 20 - 16:48}
 * @Description: Dept表的接口
 * @version:1.0
 */
public interface DeptMapper {
    /**
     * 向dept表格中添加一个部门
     * @param dept dept表格
     * @return 响应的是表格中修改的数据行数
     */
    int addDept(Dept dept);

    /**
     * 同上
     * @param dept
     * @return
     */
    int addDept2(Dept dept);
}
