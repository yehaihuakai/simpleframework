package com.dion.controller.frontend;

import com.dion.dao.MainPageInfoDto;
import com.dion.entity.dto.Result;
import com.dion.service.combine.HeadLineShopCategoryService;
import lombok.Getter;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Getter
@Controller
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryService headLineShopCategoryService;

    public Result<MainPageInfoDto> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryService.getMainPageInfo();
    }
}
