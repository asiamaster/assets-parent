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

import com.dili.assets.sdk.dto.TradeTypeDto;
import com.dili.assets.sdk.dto.TradeTypeQuery;
import com.dili.commons.bstable.TableResult;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-07-30
 **/
@FeignClient(name = "assets-service", contextId = "tradeType-service", url = "${AssetsRpc.url:}")
public interface TradeTypeRpc {

    /**
     * 查询交易类型数据分页
     */
    @RequestMapping(value = "/api/tradeType/query", method = RequestMethod.POST)
    TableResult<TradeTypeDto> query(TradeTypeQuery query);

    /**
     * 新增交易类型
     */
    @RequestMapping(value = "/api/tradeType/add", method = RequestMethod.POST)
    BaseOutput add(TradeTypeDto dto);

    /**
     * 修改交易类型
     */
    @RequestMapping(value = "/api/tradeType/update", method = RequestMethod.POST)
    BaseOutput update(TradeTypeDto dto);

    /**
     * 多选删除交易类型
     */
    @RequestMapping(value = "/api/tradeType/deleteAll", method = RequestMethod.POST)
    BaseOutput deleteAll(Long[] ids);

    /**
     * 获取交易类型
     */
    @RequestMapping(value = "/api/tradeType/get", method = RequestMethod.POST)
    BaseOutput<TradeTypeDto> get(Long id);

    /**
     * 通过编码唯一获取交易类型
     */
    @RequestMapping(value = "/api/tradeType/getByCode", method = RequestMethod.POST)
    BaseOutput<TradeTypeDto> getByCode(@RequestParam("code") String code);

}