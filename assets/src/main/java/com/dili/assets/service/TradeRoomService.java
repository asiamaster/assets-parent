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

import java.util.List;

import com.dili.assets.domain.TradeRoom;
import com.dili.assets.sdk.dto.TradeRoomQuery;
import com.dili.ss.base.BaseService;
import com.dili.ss.domain.BaseOutput;
import com.github.pagehelper.PageInfo;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @description 服务接口
 * @date 2020-07-30
 **/
public interface TradeRoomService extends BaseService<TradeRoom, Long> {

    /**
     * 查询数据分页
     *
     * @param query 条件
     * @return PageInfo<TradeRoom>
     */
    PageInfo<TradeRoom> queryAll(TradeRoomQuery query);


    /**
     * 多选删除
     *
     * @param ids /
     */
    void deleteAll(Long[] ids);

    /**
     * 新增
     *
     * @param tradeType
     * @return
     */
    BaseOutput saveTradeRoom(TradeRoom tradeRoom);

    /**
     * 修改
     *
     * @param tradeRoom
     * @return
     */
    BaseOutput updateTradeRoom(TradeRoom tradeRoom);

    /**
     * 查询列表
     *
     * @param tradeRoom
     * @return
     */
    List<TradeRoom> listTradeRoom(TradeRoom tradeRoom);

}