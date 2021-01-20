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

import com.dili.assets.domain.Config;
import com.dili.commons.glossary.EnabledStateEnum;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.ConfigService;
import com.dili.assets.sdk.dto.ConfigQuery;
import com.dili.assets.mapper.ConfigMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务实现
 * @date 2020-08-13
 **/
@Service
@RequiredArgsConstructor
public class ConfigServiceImpl extends BaseServiceImpl<Config, Long> implements ConfigService {

    private final ConfigMapper configMapper;

    @Override
    public PageInfo<Config> queryAll(ConfigQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Config> list = configMapper.selectByQuery(query);
        PageInfo<Config> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            configMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void enableAll(Long[] ids) {
        for (Long id : ids) {
            Config config = new Config();
            config.setId(id);
            config.setState(EnabledStateEnum.ENABLED.getCode());
            this.saveOrUpdateSelective(config);
        }
    }

    @Override
    public void disableAll(Long[] ids) {
        for (Long id : ids) {
            Config config = new Config();
            config.setId(id);
            config.setState(EnabledStateEnum.DISABLED.getCode());
            this.saveOrUpdateSelective(config);
        }
    }

    @Override
    public List<Config> selectAllByType(String type) {
        return configMapper.selectAllByType(type);
    }
}