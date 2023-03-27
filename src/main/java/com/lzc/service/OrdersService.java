package com.lzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.entity.Orders;

/**
 * @title: OrdersService
 * @Author luozouchen
 * @Date: 2023/3/27 14:51
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
