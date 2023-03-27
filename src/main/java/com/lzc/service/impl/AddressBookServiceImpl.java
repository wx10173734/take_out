package com.lzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.entity.AddressBook;
import com.lzc.mapper.AddressBookMapper;
import com.lzc.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @title: AddressBookServiceImpl
 * @Author luozouchen
 * @Date: 2023/3/27 13:34
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
