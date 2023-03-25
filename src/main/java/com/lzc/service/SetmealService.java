package com.lzc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.dto.SetmealDto;
import com.lzc.entity.Setmeal;

/**
 * @title: SetmealServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/18 15:22
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 套餐分页查询
     * @param setmealPage
     * @param setmealDtoPage
     */
    public void pageSetmeal(Page<Setmeal> setmealPage,Page<SetmealDto> setmealDtoPage,String name);
}
