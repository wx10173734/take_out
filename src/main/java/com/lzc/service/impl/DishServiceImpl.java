package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.dto.DishDto;
import com.lzc.entity.Dish;
import com.lzc.entity.DishFlavor;
import com.lzc.mapper.DishMapper;
import com.lzc.service.DishFlavorService;
import com.lzc.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: DishServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/18 15:19
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时保存对应的口味数据
     *
     * @param dishDto
     */
    @Transactional//开启事务
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);
        //保存菜品口味数据到菜品口味表dish_flavor
        Long dishId = dishDto.getId();//菜品id
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
//        for (DishFlavor flavor : dishDto.getFlavors()) {
//            flavor.setDishId(dishDto.getId());
//        }
        dishFlavorService.saveBatch(flavors);
    }
}
