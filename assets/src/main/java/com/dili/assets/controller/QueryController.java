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

import com.dili.assets.domain.Query;
import com.dili.assets.service.QueryService;
import com.dili.assets.sdk.dto.QueryQuery;
import com.dili.assets.sdk.dto.QueryDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-11-24
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/query")
public class QueryController {

    private final QueryService queryService;

    /**
     * 查询数据分页
     *
     * @param query 条件
     * @return PageInfo<Query>
     */
    @PostMapping("/query")
    public Object query(@RequestBody QueryQuery query) {
        PageInfo<Query> page = queryService.query(query);
        TableResult<Query> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 查询所有数据
     *
     * @param query 条件
     */
    @PostMapping("/queryAll")
    public Object queryAll(@RequestBody QueryQuery query) {
        return queryService.queryAll(query);
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody Query query) {
        queryService.saveQuery(query);
        return BaseOutput.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody Query query) {
        queryService.updateQuery(query);
        return BaseOutput.success();
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<QueryDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(queryService.get(id));
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        queryService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选启用
     */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        queryService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选禁用
     */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        queryService.disableAll(ids);
        return BaseOutput.success();
    }
}