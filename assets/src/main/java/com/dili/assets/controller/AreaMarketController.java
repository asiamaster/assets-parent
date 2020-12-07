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

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.AreaMarket;
import com.dili.assets.sdk.dto.DistrictDTO;
import com.dili.assets.service.AreaMarketService;
import com.dili.assets.sdk.dto.AreaMarketQuery;
import com.dili.assets.sdk.dto.AreaMarketDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-12-03
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/areaMarket")
public class AreaMarketController {

    private final AreaMarketService areaMarketService;

    /**
     * 查询数据分页
     *
     * @param query 条件
     * @return PageInfo<AreaMarket>
     */
    @PostMapping("/query")
    public Object query(@RequestBody AreaMarketQuery query) {
        PageInfo<AreaMarket> page = areaMarketService.query(query);
        TableResult<AreaMarket> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 查询所有数据
     *
     * @param query 条件
     */
    @PostMapping("/queryAll")
    public Object queryAll(@RequestBody AreaMarketQuery query) {
        return areaMarketService.queryAll(query);
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody List<DistrictDTO> dto) {
        return areaMarketService.saveAreaMarket(dto);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody AreaMarket areaMarket) {
        areaMarketService.updateAreaMarket(areaMarket);
        return BaseOutput.success();
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<AreaMarketDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(areaMarketService.get(id));
    }

    /**
     * 获取
     */
    @PostMapping("/getMarketByArea")
    public BaseOutput<Long> getMarketByArea(@RequestBody Long id) {
        AreaMarketQuery query = new AreaMarketQuery();
        query.setArea(id);
        BaseOutput<List<AreaMarket>> listBaseOutput = areaMarketService.queryAll(query);
        if (CollUtil.isNotEmpty(listBaseOutput.getData())) {
            return BaseOutput.success().setData(listBaseOutput.getData().get(0).getMarket());
        } else {
            return BaseOutput.success();
        }
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        areaMarketService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选启用
     */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        areaMarketService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选禁用
     */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        areaMarketService.disableAll(ids);
        return BaseOutput.success();
    }
}