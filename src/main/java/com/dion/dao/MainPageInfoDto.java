package com.dion.dao;

import com.dion.entity.bo.HeadLine;
import com.dion.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Data
public class MainPageInfoDto {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
