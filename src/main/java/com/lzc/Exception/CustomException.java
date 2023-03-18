package com.lzc.Exception;

/**
 * @title: CustomException
 * @Author luozouchen
 * @Date: 2023/3/18 15:37
 */

/**
 * 自定义业务异常
 */
public class CustomException extends RuntimeException {
    public CustomException(String messsage) {
        super(messsage);
    }
}
