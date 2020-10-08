package com.dion.service.combine.impl;

import com.dion.dao.MainPageInfoDto;
import com.dion.entity.bo.HeadLine;
import com.dion.entity.bo.ShopCategory;
import com.dion.entity.dto.Result;
import com.dion.service.combine.HeadLineShopCategoryService;
import com.dion.service.solo.HeadLineService;
import com.dion.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Service
public class HeadLineShopCategoryServiceImpl implements HeadLineShopCategoryService {

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDto> getMainPageInfo() {
        // 1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHealLine(headLineCondition, 1, 4);

        // 2.获取店铺信息列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 10);
        MainPageInfoDto dto = new MainPageInfoDto();
        dto.setHeadLineList(headLineResult.getData());
        dto.setShopCategoryList(shopCategoryResult.getData());

        Result<MainPageInfoDto> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(dto);
        return result;
    }
}
