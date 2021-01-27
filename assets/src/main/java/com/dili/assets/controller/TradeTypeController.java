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
import com.dili.assets.common.TableResult;
import com.dili.assets.domain.TradeType;
import com.dili.assets.mapper.TradeTypeMapper;
import com.dili.assets.sdk.dto.TradeTypeDto;
import com.dili.assets.sdk.dto.TradeTypeQuery;
import com.dili.assets.service.TradeTypeService;
import com.dili.ss.domain.BaseOutput;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-07-30
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tradeType")
public class TradeTypeController {

    private final TradeTypeService tradeTypeService;

    private final TradeTypeMapper tradeTypeMapper;

    /**
     * 查询数据分页
     *
     * @param query 条件
     * @return PageInfo<TradeType>
     */
    @PostMapping("/query")
    public Object query(@RequestBody TradeTypeQuery query) {
        PageInfo<TradeType> page = tradeTypeService.queryAll(query);
        TableResult<TradeType> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 查询所有数据
     *
     * @return List<TradeType>
     */
    @PostMapping("/queryAll")
    public Object queryAll(@RequestBody(required = false) TradeTypeQuery query) {
        return BaseOutput.successData(tradeTypeMapper.selectByQuery(query));
    }

    /**
     * 根据编码查询交易类型
     */
    @PostMapping("/getByCode")
    public BaseOutput<TradeTypeDto> getByCode(String code) {
        TradeType query = new TradeType();
        query.setCode(code);
        List<TradeType> tradeTypes = tradeTypeService.listByExample(query);
        if (CollUtil.isNotEmpty(tradeTypes)) {
            return BaseOutput.success().setData(tradeTypes.get(0));
        }
        return BaseOutput.success();
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody TradeType tradeType) {
        return tradeTypeService.saveTradeType(tradeType);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody TradeType tradeType) {
        return tradeTypeService.updateTradeType(tradeType);
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