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
package com.dili.assets.service;

import com.dili.assets.domain.TradeType;
import com.dili.assets.sdk.dto.TradeTypeQuery;
import com.dili.ss.base.BaseService;
import com.dili.ss.domain.BaseOutput;
import com.github.pagehelper.PageInfo;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务接口
 * @date 2020-07-30
 **/
public interface TradeTypeService extends BaseService<TradeType, Long> {

    /**
     * 查询数据分页
     *
     * @param query 条件
     * @return PageInfo<TradeType>
     */
    PageInfo<TradeType> queryAll(TradeTypeQuery query);


    /**
     * 多选删除
     *
     * @param ids /
     */
    void deleteAll(Long[] ids);

    /**
     *  新增
     * @param tradeType
     * @return
     */
    BaseOutput saveTradeType(TradeType tradeType);

    /**
     *  修改
     * @param tradeType
     * @return
     */
    BaseOutput updateTradeType(TradeType tradeType);

}