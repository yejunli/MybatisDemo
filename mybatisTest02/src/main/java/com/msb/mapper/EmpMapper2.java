package com.msb.mapper;


import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: YeZhanCHN
 * @Date: 2021/6/19 - 06 - 19 - 22:40}
 * @Description: EmpMapper接口
 * @version:1.0
 */
public interface EmpMapper2 {
    List<Emp> findByCondition(Emp emp);
}
