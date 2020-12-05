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

import com.dili.assets.sdk.dto.AreaMarketDto;
import com.dili.assets.sdk.dto.AreaMarketQuery;
import com.dili.assets.sdk.dto.DistrictDTO;
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
@FeignClient(name = "assets-service", contextId = "areaMarket-service", url = "${AssetsRpc.url:}")
public interface AreaMarketRpc {

    /**
    * 查询区域商户数据分页
    */
    @RequestMapping(value = "/api/areaMarket/query", method = RequestMethod.POST)
    TableResult<AreaMarketDto> query(AreaMarketQuery query);

    /**
    * 查询区域商户数据
    */
    @RequestMapping(value = "/api/areaMarket/queryAll", method = RequestMethod.POST)
    BaseOutput<List<AreaMarketDto>> queryAll(AreaMarketQuery query);

    /**
    * 新增区域商户
    */
    @RequestMapping(value = "/api/areaMarket/add", method = RequestMethod.POST)
    BaseOutput add(List<DistrictDTO> dto);

    /**
    * 修改区域商户
    */
    @RequestMapping(value = "/api/areaMarket/update", method = RequestMethod.POST)
    BaseOutput update(AreaMarketDto dto);

    /**
    * 多选删除区域商户
    */
    @RequestMapping(value = "/api/areaMarket/deleteAll", method = RequestMethod.POST)
    BaseOutput deleteAll(Long[] ids);

    /**
    * 多选启用区域商户
    */
    @RequestMapping(value = "/api/areaMarket/enableAll", method = RequestMethod.POST)
    BaseOutput enableAll(Long[] ids);

    /**
    * 多选禁用区域商户
    */
    @RequestMapping(value = "/api/areaMarket/disableAll", method = RequestMethod.POST)
    BaseOutput disableAll(Long[] ids);

    /**
    * 获取区域商户
    */
    @RequestMapping(value = "/api/areaMarket/get", method = RequestMethod.POST)
    BaseOutput<AreaMarketDto> get(Long id);

}