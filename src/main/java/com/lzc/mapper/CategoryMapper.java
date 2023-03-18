package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: CategoryMapper
 * @Author luozouchen
 * @Date: 2023/3/18 12:47
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
