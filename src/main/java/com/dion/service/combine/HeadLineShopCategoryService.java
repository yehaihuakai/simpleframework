package com.dion.service.combine;

import com.dion.dao.MainPageInfoDto;
import com.dion.entity.dto.Result;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
public interface HeadLineShopCategoryService {
    Result<MainPageInfoDto> getMainPageInfo();
}
