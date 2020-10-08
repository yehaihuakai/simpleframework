package com.dion.service.solo.impl;

import com.dion.entity.bo.ShopCategory;
import com.dion.entity.dto.Result;
import com.dion.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addshopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeshopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyshopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryshopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCondition, int pageIndex, int pageSize) {
        return null;
    }
}
