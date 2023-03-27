package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.OrderDetail;
import com.lzc.mapper.OrderDetailMapper;
import com.lzc.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @title: OrderDetailServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/27 14:53
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
