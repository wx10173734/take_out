package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.ShoppingCart;
import com.lzc.mapper.ShoppingCartMapper;
import com.lzc.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @title: ShoppingCartServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/27 13:52
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
