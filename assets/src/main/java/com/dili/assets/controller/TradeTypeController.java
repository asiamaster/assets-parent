/*
*  Copyright 2019-2020 ShaoFan
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package com.dili.assets.controller;

import com.dili.assets.domain.TradeType;
import com.dili.assets.sdk.dto.TradeTypeDto;
import com.dili.assets.service.TradeTypeService;
import com.dili.assets.sdk.dto.TradeTypeQuery;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.assets.common.TableResult;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-07-30
**/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tradeType")
public class TradeTypeController {

    private final TradeTypeService tradeTypeService;

    /**
     * 查询数据分页
     * @param query 条件
     * @param pageable 分页参数
     * @return PageInfo<TradeType>
     */
    @PostMapping("/query")
    public Object query(@RequestBody TradeTypeQuery query){
        PageInfo<TradeType> page = tradeTypeService.queryAll(query);
        TableResult<TradeType> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody TradeType tradeType){
        tradeTypeService.saveOrUpdate(tradeType);
        return BaseOutput.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody TradeType tradeType){
        tradeTypeService.updateSelective(tradeType);
        return BaseOutput.success();
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<TradeTypeDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(tradeTypeService.get(id));
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        tradeTypeService.deleteAll(ids);
        return BaseOutput.success();
    }
}