package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: EmployeeMapper
 * @Author luozouchen
 * @Date: 2023/3/11 13:58
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
