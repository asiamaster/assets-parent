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

import com.dili.assets.domain.TypeMarket;
import com.dili.assets.service.TypeMarketService;
import com.dili.assets.sdk.dto.TypeMarketQuery;
import com.dili.assets.sdk.dto.TypeMarketDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-12-03
**/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/typeMarket")
public class TypeMarketController {

    private final TypeMarketService typeMarketService;


    /**
    * 查询所有数据
    * @param query 条件
    */
    @PostMapping("/queryAll")
    public Object queryAll(){
        return typeMarketService.queryAll(null);
    }

    /**
    * 新增
    */
    @PostMapping("/add")
    public Object add(@RequestBody TypeMarket typeMarket){
        typeMarketService.saveTypeMarket(typeMarket);
        return BaseOutput.success();
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    public Object update(@RequestBody TypeMarket typeMarket){
        typeMarketService.updateTypeMarket(typeMarket);
        return BaseOutput.success();
    }

    /**
    * 获取
    */
    @PostMapping("/get")
    public BaseOutput<TypeMarketDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(typeMarketService.get(id));
    }

    /**
    * 多选删除
    */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        typeMarketService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选启用
    */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        typeMarketService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
    * 多选禁用
    */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        typeMarketService.disableAll(ids);
        return BaseOutput.success();
    }
}