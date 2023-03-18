package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.Category;
import com.lzc.mapper.CategoryMapper;
import com.lzc.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @title: CategoryServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/18 12:48
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
