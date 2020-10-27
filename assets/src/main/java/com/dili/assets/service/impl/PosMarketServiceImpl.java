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
import com.dili.assets.domain.PosMarket;
import com.dili.assets.sdk.dto.PosMarketDto;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.IDTO;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.PosMarketService;
import com.dili.assets.sdk.dto.PosMarketQuery;
import com.dili.assets.mapper.PosMarketMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务实现
 * @date 2020-10-15
 **/
@Service
@RequiredArgsConstructor
public class PosMarketServiceImpl extends BaseServiceImpl<PosMarket, Long> implements PosMarketService {

    private final PosMarketMapper posMarketMapper;

    @Override
    public PageInfo<PosMarket> queryAll(PosMarketQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<PosMarket> list = posMarketMapper.selectByQuery(query);
        PageInfo<PosMarket> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            posMarketMapper.deleteByPrimaryKey(id);
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
    public BaseOutput savePosMarket(PosMarket posMarket) {
        PosMarket query = new PosMarket();
        query.setName(posMarket.getName());
        query.setMarket(posMarket.getMarket());
        if (CollUtil.isNotEmpty(this.listByExample(query))) {
            return BaseOutput.failure("名称重复");
        }
        this.saveOrUpdate(posMarket);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updatePosMarket(PosMarket posMarket) {
        PosMarket query = new PosMarket();
        query.setName(posMarket.getName());
        query.setMarket(posMarket.getMarket());
        query.setMetadata(IDTO.AND_CONDITION_EXPR, "id !=" + posMarket.getId());
        if (CollUtil.isNotEmpty(this.listByExample(query))) {
            return BaseOutput.failure("名称重复");
        }
        this.updateSelective(posMarket);
        return BaseOutput.success();
    }
}