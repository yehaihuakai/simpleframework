package com.dion.controller.frontend;

import com.dion.dao.MainPageInfoDto;
import com.dion.entity.dto.Result;
import com.dion.service.combine.HeadLineShopCategoryService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Controller
public class MainPageController {

    private HeadLineShopCategoryService headLineShopCategoryService;

    public Result<MainPageInfoDto> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryService.getMainPageInfo();
    }
}
