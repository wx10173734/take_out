package com.lzc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.dto.SetmealDto;
import com.lzc.entity.Category;
import com.lzc.entity.Setmeal;
import com.lzc.entity.SetmealDish;
import com.lzc.mapper.SetmealMapper;
import com.lzc.service.CategoryService;
import com.lzc.service.SetmealDishService;
import com.lzc.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: SetmealServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/18 15:22
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     *
     * @param setmealDto
     */
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息，操作setmeal,执行insert操作
        this.save(setmealDto);
        //保存套餐和菜品的关联信息，操作setmeal_dish,执行insert操作

        Long setmealId = setmealDto.getId();//套餐Id
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes = setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealId);
            return item;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 套餐分页查询
     *
     * @param setmealPage
     * @param setmealDtoPage
     */
    @Override
    public void pageSetmeal(Page<Setmeal> setmealPage, Page<SetmealDto> setmealDtoPage, String name) {
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据Name进行模糊查询
        setmealLambdaQueryWrapper.like(name != null, Setmeal::getName, name);
        //添加排序条件，根据更新进行模糊查询
        setmealLambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        this.page(setmealPage, setmealLambdaQueryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(setmealPage, setmealDtoPage, "records");
        List<Setmeal> records = setmealPage.getRecords();
        List<SetmealDto> setmealDtoList = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //因为setmealDto是new出来的，都是空的，所以需要进行对象拷贝，把item里面的数据拷进去
            BeanUtils.copyProperties(item, setmealDto);
            //分类id
            Long categoryId = setmealDto.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                setmealDto.setCategoryName(category.getName());
            }
            return setmealDto;
        }).collect(Collectors.toList());

        setmealDtoPage.setRecords(setmealDtoList);
    }
}
