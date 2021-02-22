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
import com.dili.assets.domain.Funditem;
import com.dili.assets.service.FunditemService;
import com.dili.assets.sdk.dto.FunditemQuery;
import com.dili.assets.sdk.dto.FunditemDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

import java.util.List;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2021-02-22
**/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/funditem")
public class FunditemController {

    private final FunditemService funditemService;

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<Funditem>
    */
    @PostMapping("/query")
    public Object query(@RequestBody FunditemQuery query){
        PageInfo<Funditem> page = funditemService.query(query);
        TableResult<Funditem> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
    * 查询所有数据
    * @param query 条件
    */
    @PostMapping("/queryAll")
    public Object queryAll(@RequestBody FunditemQuery query){
        return funditemService.queryAll(query);
    }

    /**
    * 新增
    */
    @PostMapping("/add")
    public Object add(@RequestBody Funditem funditem) {
        Funditem query = new Funditem();
        query.setName(funditem.getName());
        List<Funditem> nameCheck = funditemService.listByExample(query);
        if (CollUtil.isNotEmpty(nameCheck)) {
            return BaseOutput.failure("5000", "资金项重复");
        }
        funditemService.saveFunditem(funditem);
        return BaseOutput.success();
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    public Object update(@RequestBody Funditem funditem){
        funditemService.updateFunditem(funditem);
        return BaseOutput.success();
    }

    /**
    * 获取
    */
    @PostMapping("/get")
    public BaseOutput<FunditemDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(funditemService.get(id));
    }

    /**
    * 多选删除
    */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        funditemService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选启用
    */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        funditemService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选禁用
    */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        funditemService.disableAll(ids);
        return BaseOutput.success();
    }
}