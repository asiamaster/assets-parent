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

import com.dili.assets.domain.PosMarket;
import com.dili.assets.service.PosMarketService;
import com.dili.assets.sdk.dto.PosMarketQuery;
import com.dili.assets.sdk.dto.PosMarketDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-10-15
**/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posMarket")
public class PosMarketController {

    private final PosMarketService posMarketService;

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<PosMarket>
    */
    @PostMapping("/query")
    public Object query(@RequestBody PosMarketQuery query){
        PageInfo<PosMarket> page = posMarketService.queryAll(query);
        TableResult<PosMarket> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
    * 新增
    */
    @PostMapping("/add")
    public Object add(@RequestBody PosMarket posMarket){
        posMarketService.savePosMarket(posMarket);
        return BaseOutput.success();
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    public Object update(@RequestBody PosMarket posMarket){
        posMarketService.updatePosMarket(posMarket);
        return BaseOutput.success();
    }

    /**
    * 获取
    */
    @PostMapping("/get")
    public BaseOutput<PosMarketDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(posMarketService.get(id));
    }

    /**
    * 多选删除
    */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        posMarketService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选启用
    */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        posMarketService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选禁用
    */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        posMarketService.disableAll(ids);
        return BaseOutput.success();
    }
}