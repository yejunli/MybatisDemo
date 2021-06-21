package com.msb.mapper;


import com.msb.pojo.Emp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:40}
 * @Description: EmpMapper接口
 * @version:1.0
 */
public interface EmpMapper {
    /**
     * 查询全部员工信息
     * @return 返回的是全部的对象
     */
    List<Emp> findAll();
}
