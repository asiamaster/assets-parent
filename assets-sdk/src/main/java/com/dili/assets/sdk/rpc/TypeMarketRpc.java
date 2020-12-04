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
package com.dili.assets.sdk.rpc;

import com.dili.assets.sdk.dto.TypeMarketDto;
import com.dili.assets.sdk.dto.TypeMarketQuery;
import com.dili.ss.domain.BaseOutput;
import com.dili.commons.bstable.TableResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-12-03
**/
@FeignClient(name = "assets-service", contextId = "typeMarket-service", url = "${AssetsRpc.url:}")
public interface TypeMarketRpc {

    /**
    * 查询业务商户数据分页
    */
    @RequestMapping(value = "/api/typeMarket/query", method = RequestMethod.POST)
    TableResult<TypeMarketDto> query(TypeMarketQuery query);

    /**
    * 查询业务商户数据
    */
    @RequestMapping(value = "/api/typeMarket/queryAll", method = RequestMethod.POST)
    BaseOutput<List<TypeMarketDto>> queryAll();

    /**
    * 新增业务商户
    */
    @RequestMapping(value = "/api/typeMarket/add", method = RequestMethod.POST)
    BaseOutput add(TypeMarketDto dto);

    /**
    * 修改业务商户
    */
    @RequestMapping(value = "/api/typeMarket/update", method = RequestMethod.POST)
    BaseOutput update(TypeMarketDto dto);

    /**
    * 多选删除业务商户
    */
    @RequestMapping(value = "/api/typeMarket/deleteAll", method = RequestMethod.POST)
    BaseOutput deleteAll(Long[] ids);

    /**
    * 多选启用业务商户
    */
    @RequestMapping(value = "/api/typeMarket/enableAll", method = RequestMethod.POST)
    BaseOutput enableAll(Long[] ids);

    /**
    * 多选禁用业务商户
    */
    @RequestMapping(value = "/api/typeMarket/disableAll", method = RequestMethod.POST)
    BaseOutput disableAll(Long[] ids);

    /**
    * 获取业务商户
    */
    @RequestMapping(value = "/api/typeMarket/get", method = RequestMethod.POST)
    BaseOutput<TypeMarketDto> get(Long id);

}