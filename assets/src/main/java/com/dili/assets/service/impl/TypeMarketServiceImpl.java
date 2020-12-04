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

import com.dili.assets.domain.TypeMarket;
import com.dili.ss.domain.BaseOutput;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.TypeMarketService;
import com.dili.assets.sdk.dto.TypeMarketQuery;
import com.dili.assets.mapper.TypeMarketMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;
import java.util.List;

/**
* @website http://shaofan.org
* @description 服务实现
* @author shaofan
* @date 2020-12-03
**/
@Service
@RequiredArgsConstructor
public class TypeMarketServiceImpl extends BaseServiceImpl<TypeMarket, Long> implements TypeMarketService {

    private final TypeMarketMapper typeMarketMapper;

    @Override
    public PageInfo<TypeMarket> query(TypeMarketQuery query){
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<TypeMarket> list = typeMarketMapper.selectByQuery(query);
        PageInfo<TypeMarket> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseOutput<List<TypeMarket>> queryAll(TypeMarketQuery query){
        List<TypeMarket> list = typeMarketMapper.selectByQuery(query);
        return BaseOutput.successData(list);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            typeMarketMapper.deleteByPrimaryKey(id);
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
    public BaseOutput saveTypeMarket(TypeMarket typeMarket) {
        this.saveOrUpdate(typeMarket);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateTypeMarket(TypeMarket typeMarket) {
        this.updateSelective(typeMarket);
        return BaseOutput.success();
    }
}