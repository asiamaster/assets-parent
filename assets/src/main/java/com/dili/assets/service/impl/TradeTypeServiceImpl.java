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
package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.TradeType;
import com.dili.assets.mapper.TradeTypeMapper;
import com.dili.assets.sdk.dto.TradeTypeQuery;
import com.dili.assets.service.TradeTypeService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.IDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务实现
 * @date 2020-07-30
 **/
@Service
@RequiredArgsConstructor
public class TradeTypeServiceImpl extends BaseServiceImpl<TradeType, Long> implements TradeTypeService {

    private final TradeTypeMapper tradeTypeMapper;

    @Override
    public PageInfo<TradeType> queryAll(TradeTypeQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<TradeType> list = tradeTypeMapper.selectByQuery(query);
        PageInfo<TradeType> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            tradeTypeMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public BaseOutput saveTradeType(TradeType tradeType) {
        TradeType query = new TradeType();
        query.setName(tradeType.getName());
        query.setMarketId(tradeType.getMarketId());
        if (CollUtil.isNotEmpty(this.listByExample(query))) {
            return BaseOutput.failure("类型名称重复");
        }

        query = new TradeType();
        query.setCode(tradeType.getCode());
        query.setMarketId(tradeType.getMarketId());
        if (CollUtil.isNotEmpty(this.listByExample(query))) {
            return BaseOutput.failure("类型编码重复");
        }
        this.saveOrUpdate(tradeType);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateTradeType(TradeType tradeType) {
        TradeType query = new TradeType();
        query.setName(tradeType.getName());
        query.setMetadata(IDTO.AND_CONDITION_EXPR, "id !=" + tradeType.getId());
        if (CollUtil.isNotEmpty(this.listByExample(query))) {
            return BaseOutput.failure("类型名称重复");
        }

        this.updateSelective(tradeType);
        return BaseOutput.success();
    }
}