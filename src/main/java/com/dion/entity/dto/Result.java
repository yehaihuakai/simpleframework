package com.dion.entity.dto;

import lombok.Data;

/**
 * @description: 统一返回类
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Data
public class Result<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 结果详情
     */
    private String msg;
    /**
     * 结果集
     */
    private T data;
}
