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

import com.dili.assets.domain.Funditem;
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.ss.domain.BaseOutput;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.FunditemService;
import com.dili.assets.sdk.dto.FunditemQuery;
import com.dili.assets.mapper.FunditemMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;
import java.util.List;

/**
* @website http://shaofan.org
* @description 服务实现
* @author shaofan
* @date 2021-02-22
**/
@Service
@RequiredArgsConstructor
public class FunditemServiceImpl extends BaseServiceImpl<Funditem, Long> implements FunditemService {

    private final FunditemMapper funditemMapper;

    @Override
    public PageInfo<Funditem> query(FunditemQuery query){
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Funditem> list = funditemMapper.selectByQuery(query);
        PageInfo<Funditem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseOutput<List<Funditem>> queryAll(FunditemQuery query){
        List<Funditem> list = funditemMapper.selectByQuery(query);
        return BaseOutput.successData(list);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            funditemMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void enableAll(Long[] ids) {
        for (Long id : ids) {
            Funditem funditem = new Funditem();
            funditem.setId(id);
            funditem.setState(EnabledStateEnum.ENABLED.getCode());
            this.saveOrUpdateSelective(funditem);
        }
    }

    @Override
    public void disableAll(Long[] ids) {
        for (Long id : ids) {
            Funditem funditem = new Funditem();
            funditem.setId(id);
            funditem.setState(EnabledStateEnum.DISABLED.getCode());
            this.saveOrUpdateSelective(funditem);
        }
    }

    @Override
    public BaseOutput saveFunditem(Funditem funditem) {
        this.saveOrUpdate(funditem);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateFunditem(Funditem funditem) {
        this.updateSelective(funditem);
        return BaseOutput.success();
    }
}