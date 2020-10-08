package com.dion.controller.superadmin;

import com.dion.entity.bo.HeadLine;
import com.dion.entity.dto.Result;
import com.dion.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
@Controller
public class HeadLineOperationController {

    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return headLineService.removeHeadLine(0);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return headLineService.queryHeadLineById(0);
    }

    public Result<List<HeadLine>> queryHealLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO：参数校验以及请求参数转化
        return headLineService.queryHealLine(new HeadLine(), 1, 10);
    }
}
