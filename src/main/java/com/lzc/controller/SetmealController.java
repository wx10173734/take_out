package com.lzc.controller;

import com.lzc.common.R;
import com.lzc.dto.SetmealDto;
import com.lzc.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: SetmealController
 * @Author luozouchen
 * @Date: 2023/3/18 15:24
 */
@RestController
@Slf4j
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        log.info(String.valueOf(setmealDto));
        setmealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功");
    }
}
