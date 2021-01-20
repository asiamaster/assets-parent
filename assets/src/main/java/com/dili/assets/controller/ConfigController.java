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

import com.dili.assets.domain.Config;
import com.dili.assets.service.ConfigService;
import com.dili.assets.sdk.dto.ConfigQuery;
import com.dili.assets.sdk.dto.ConfigDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.assets.common.TableResult;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-08-13
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/config")
public class ConfigController {

    private final ConfigService configService;

    /**
     * 查询数据分页
     *
     * @param query    条件
     * @param pageable 分页参数
     * @return PageInfo<Config>
     */
    @PostMapping("/query")
    public Object query(@RequestBody ConfigQuery query) {
        PageInfo<Config> page = configService.queryAll(query);
        TableResult<Config> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody Config config) {
        configService.saveOrUpdate(config);
        return BaseOutput.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody Config config) {
        configService.updateSelective(config);
        return BaseOutput.success();
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<ConfigDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(configService.get(id));
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        configService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选启用
     */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        configService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选禁用
     */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        configService.disableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 查询分组
     */
    @PostMapping("/searchGroup")
    public BaseOutput<List<ConfigDto>> searchGroup(@RequestBody String keyword) {
        return BaseOutput.success().setData(configService.selectAllByType(keyword));
    }
}