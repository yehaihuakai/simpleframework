package com.dion.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
