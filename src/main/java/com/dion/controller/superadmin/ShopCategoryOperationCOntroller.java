package com.dion.controller.superadmin;

import com.dion.entity.bo.ShopCategory;
import com.dion.entity.dto.Result;
import com.dion.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
public class ShopCategoryOperationCOntroller {

    private ShopCategoryService shopCategoryService;

    public Result<Boolean> addshopCategory(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return shopCategoryService.addshopCategory(new ShopCategory());
    }

    public Result<Boolean> removeshopCategory(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return shopCategoryService.removeshopCategory(0);
    }

    public Result<Boolean> modifyshopCategory(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return shopCategoryService.modifyshopCategory(new ShopCategory());
    }

    public Result<ShopCategory> queryshopCategoryById(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return shopCategoryService.queryshopCategoryById(0);
    }

    public Result<List<ShopCategory>> queryShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return shopCategoryService.queryShopCategory(new ShopCategory(), 1, 10);
    }
}
