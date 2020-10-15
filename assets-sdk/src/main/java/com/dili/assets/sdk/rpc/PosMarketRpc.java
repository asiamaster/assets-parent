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

import com.dili.assets.sdk.dto.PosMarketDto;
import com.dili.assets.sdk.dto.PosMarketQuery;
import com.dili.commons.bstable.TableResult;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-10-15
**/
@FeignClient(name = "assets-service", contextId = "posMarketRpc", url = "${AssetsRpc.url:}")
public interface PosMarketRpc {

    /**
    * 查询销地市场数据分页
    */
    @RequestMapping(value = "/api/posMarket/query", method = RequestMethod.POST)
    TableResult<PosMarketDto> query(PosMarketQuery query);

    /**
    * 新增销地市场
    */
    @RequestMapping(value = "/api/posMarket/add", method = RequestMethod.POST)
    BaseOutput add(PosMarketDto dto);

    /**
    * 修改销地市场
    */
    @RequestMapping(value = "/api/posMarket/update", method = RequestMethod.POST)
    BaseOutput update(PosMarketDto dto);

    /**
    * 多选删除销地市场
    */
    @RequestMapping(value = "/api/posMarket/deleteAll", method = RequestMethod.POST)
    BaseOutput deleteAll(Long[] ids);

    /**
    * 多选启用销地市场
    */
    @RequestMapping(value = "/api/posMarket/enableAll", method = RequestMethod.POST)
    BaseOutput enableAll(Long[] ids);

    /**
    * 多选禁用销地市场
    */
    @RequestMapping(value = "/api/posMarket/disableAll", method = RequestMethod.POST)
    BaseOutput disableAll(Long[] ids);

    /**
    * 获取销地市场
    */
    @RequestMapping(value = "/api/posMarket/get", method = RequestMethod.POST)
    BaseOutput<PosMarketDto> get(Long id);

}