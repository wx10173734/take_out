package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.Employee;
import com.lzc.mapper.EmployeeMapper;
import com.lzc.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @title: EmployeeServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/11 13:59
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
