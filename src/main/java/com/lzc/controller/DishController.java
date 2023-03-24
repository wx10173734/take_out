package com.lzc.controller;

import com.lzc.common.R;
import com.lzc.dto.DishDto;
import com.lzc.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: DishController
 * @Author luozouchen
 * @Date: 2023/3/18 15:19
 */
@RestController
@Slf4j
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 新增菜品
     *
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        log.info(String.valueOf(dishDto));
        dishService.saveWithFlavor(dishDto);
        return R.success("新增菜品成功");
    }
}
