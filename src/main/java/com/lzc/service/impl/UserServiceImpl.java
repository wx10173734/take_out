package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.User;
import com.lzc.mapper.UserMapper;
import com.lzc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @title: UserServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/25 21:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
