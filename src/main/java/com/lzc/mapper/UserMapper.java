package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: UserMapper
 * @Author luozouchen
 * @Date: 2023/3/25 21:28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
