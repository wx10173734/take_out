package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.Dish;
import com.lzc.mapper.DishMapper;
import com.lzc.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @title: DishServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/18 15:19
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
