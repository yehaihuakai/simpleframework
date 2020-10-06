package com.dion.service.solo;

import com.dion.entity.bo.HeadLine;
import com.dion.entity.dto.Result;

import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHealLine(HeadLine headCondition, int pageIndex, int pageSize);
}
