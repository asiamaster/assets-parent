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

import com.dili.assets.domain.TradeRoom;
import com.dili.assets.service.TradeRoomService;
import com.dili.assets.sdk.dto.TradeRoomQuery;
import com.dili.assets.sdk.dto.TradeRoomDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.assets.common.TableResult;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-07-30
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tradeRoom")
public class TradeRoomController {

    private final TradeRoomService tradeRoomService;

    /**
     * 查询数据分页
     *
     * @param query    条件
     * @param pageable 分页参数
     * @return PageInfo<TradeRoom>
     */
    @PostMapping("/query")
    public Object query(TradeRoomQuery query) {
        PageInfo<TradeRoom> page = tradeRoomService.queryAll(query);
        TableResult<TradeRoom> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody TradeRoom tradeRoom) {
        return tradeRoomService.saveTradeRoom(tradeRoom);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody TradeRoom tradeRoom) {
        return tradeRoomService.updateTradeRoom(tradeRoom);
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<TradeRoomDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(tradeRoomService.get(id));
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        tradeRoomService.deleteAll(ids);
        return BaseOutput.success();
    }
}