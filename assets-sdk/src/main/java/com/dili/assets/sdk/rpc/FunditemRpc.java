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

import com.dili.assets.sdk.dto.FunditemDto;
import com.dili.assets.sdk.dto.FunditemQuery;
import com.dili.commons.bstable.TableResult;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2021-02-22
**/
@FeignClient(name = "assets-service", contextId = "funditem-service", url = "${AssetsRpc.url:}")
public interface FunditemRpc {

    /**
    * 查询资金项数据分页
    */
    @RequestMapping(value = "/api/funditem/query", method = RequestMethod.POST)
    TableResult<FunditemDto> query(FunditemQuery query);

    /**
    * 查询资金项数据
    */
    @RequestMapping(value = "/api/funditem/queryAll", method = RequestMethod.POST)
    BaseOutput<List<FunditemDto>> queryAll(FunditemQuery query);

    /**
    * 新增资金项
    */
    @RequestMapping(value = "/api/funditem/add", method = RequestMethod.POST)
    BaseOutput add(FunditemDto dto);

    /**
    * 修改资金项
    */
    @RequestMapping(value = "/api/funditem/update", method = RequestMethod.POST)
    BaseOutput update(FunditemDto dto);

    /**
    * 多选删除资金项
    */
    @RequestMapping(value = "/api/funditem/deleteAll", method = RequestMethod.POST)
    BaseOutput deleteAll(Long[] ids);

    /**
    * 多选启用资金项
    */
    @RequestMapping(value = "/api/funditem/enableAll", method = RequestMethod.POST)
    BaseOutput enableAll(Long[] ids);

    /**
    * 多选禁用资金项
    */
    @RequestMapping(value = "/api/funditem/disableAll", method = RequestMethod.POST)
    BaseOutput disableAll(Long[] ids);

    /**
    * 获取资金项
    */
    @RequestMapping(value = "/api/funditem/get", method = RequestMethod.POST)
    BaseOutput<FunditemDto> get(Long id);

}