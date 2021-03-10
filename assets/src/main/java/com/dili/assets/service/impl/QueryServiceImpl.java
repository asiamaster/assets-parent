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
import com.dili.assets.domain.Query;
import com.dili.ss.domain.BaseOutput;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.QueryService;
import com.dili.assets.sdk.dto.QueryQuery;
import com.dili.assets.mapper.QueryMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务实现
 * @date 2020-11-24
 **/
@Service
@RequiredArgsConstructor
public class QueryServiceImpl extends BaseServiceImpl<Query, Long> implements QueryService {

    private final QueryMapper queryMapper;

    @Override
    public PageInfo<Query> query(QueryQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Query> list = queryMapper.selectByQuery(query);
        PageInfo<Query> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseOutput<List<Query>> queryAll(QueryQuery query) {
        List<Query> list = queryMapper.selectByQuery(query);
        return BaseOutput.successData(list);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            queryMapper.deleteByPrimaryKey(id);
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
    public BaseOutput saveQuery(Query query) {
        Query queryQuery = new Query();
        queryQuery.setModel(query.getModel());
        queryQuery.setCreatorId(query.getCreatorId());
        this.deleteByExample(queryQuery);

        this.saveOrUpdate(query);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateQuery(Query query) {
        this.updateSelective(query);
        return BaseOutput.success();
    }
}