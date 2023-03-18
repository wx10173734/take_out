package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: DishMapper
 * @Author luozouchen
 * @Date: 2023/3/18 15:18
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
