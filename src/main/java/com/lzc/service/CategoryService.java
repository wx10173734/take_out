package com.lzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.entity.Category;

/**
 * @title: CategoryService
 * @Author luozouchen
 * @Date: 2023/3/18 12:47
 */
public interface CategoryService extends IService<Category> {

    /**
     * 根据id来删除分类，删除之前需要进行判断
     *
     * @param id
     */
    public void remove(Long id);
}
