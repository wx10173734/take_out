package com.lzc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 分页查询菜品数据
     *
     * @param pageInfo
     * @param dishDtoPage
     * @param name
     */
    public void pageDish(Page<Dish> pageInfo, Page<DishDto> dishDtoPage, String name);

    /**
     * 根据id查询菜品信息和对应的口味信息
     *
     * @param id
     * @return
     */
    public DishDto getByIdWithFlavor(Long id);


    /**
     * 更新菜品表和口味表
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);
}
