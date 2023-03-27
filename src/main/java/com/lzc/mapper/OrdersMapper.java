package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: OrdersMapper
 * @Author luozouchen
 * @Date: 2023/3/27 14:51
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
