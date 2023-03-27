package com.lzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: AddressBookMapper
 * @Author luozouchen
 * @Date: 2023/3/27 13:32
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
