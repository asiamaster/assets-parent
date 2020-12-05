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

import com.dili.assets.domain.AreaMarket;
import com.dili.assets.sdk.dto.DistrictDTO;
import com.dili.ss.domain.BaseOutput;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.AreaMarketService;
import com.dili.assets.sdk.dto.AreaMarketQuery;
import com.dili.assets.mapper.AreaMarketMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务实现
 * @date 2020-12-03
 **/
@Service
@RequiredArgsConstructor
public class AreaMarketServiceImpl extends BaseServiceImpl<AreaMarket, Long> implements AreaMarketService {

    private final AreaMarketMapper areaMarketMapper;

    @Override
    public PageInfo<AreaMarket> query(AreaMarketQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<AreaMarket> list = areaMarketMapper.selectByQuery(query);
        PageInfo<AreaMarket> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseOutput<List<AreaMarket>> queryAll(AreaMarketQuery query) {
        List<AreaMarket> list = areaMarketMapper.selectByQuery(query);
        return BaseOutput.successData(list);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            areaMarketMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void enableAll(Long[] ids) {
        for (Long id : ids) {
            System.out.println("自行实现批量启用");
        }
    }

    @Override
    public void disableAll(Long[] ids) {
        for (Long id : ids) {
            System.out.println("自行实现批量禁用");
        }
    }

    @Override
    public BaseOutput saveAreaMarket(@RequestBody List<DistrictDTO> dto) {
        com.dili.assets.domain.query.AreaMarketQuery query = new com.dili.assets.domain.query.AreaMarketQuery();
        query.setIds(dto.stream().map(DistrictDTO::getId).collect(Collectors.toList()));
        this.deleteByExample(query);
        List<AreaMarket> batchIns = new ArrayList<>();
        dto.forEach(it -> {
            if (it.getMarketId() != null) {
                AreaMarket areaMarket = new AreaMarket();
                areaMarket.setMarket(it.getMarketId());
                areaMarket.setArea(it.getId());
                batchIns.add(areaMarket);
            }
        });
        this.batchInsert(batchIns);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateAreaMarket(AreaMarket areaMarket) {
        this.updateSelective(areaMarket);
        return BaseOutput.success();
    }
}