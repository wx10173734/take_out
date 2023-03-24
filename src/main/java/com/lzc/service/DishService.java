package com.lzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.dto.DishDto;
import com.lzc.entity.Dish;

/**
 * @title: DishService
 * @Author luozouchen
 * @Date: 2023/3/18 15:19
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，操作两张表dish,dish_flavor

    /**
     * 新增菜品，同时保存对应的口味数据
     *
     * @param dishDto
     */
    public void saveWithFlavor(DishDto dishDto);
}
