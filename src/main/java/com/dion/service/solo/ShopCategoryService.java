package com.dion.service.solo;

import com.dion.entity.bo.ShopCategory;
import com.dion.entity.dto.Result;

import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
public interface ShopCategoryService {
    Result<Boolean> addshopCategory(ShopCategory shopCategory);

    Result<Boolean> removeshopCategory(int shopCategoryId);

    Result<Boolean> modifyshopCategory(ShopCategory shopCategory);

    Result<ShopCategory> queryshopCategoryById(int shopCategoryId);

    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCondition, int pageIndex, int pageSize);
}
