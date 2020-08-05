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
package com.dili.assets.service.impl;

import com.dili.assets.domain.TradeRoom;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.TradeRoomService;
import com.dili.assets.sdk.dto.TradeRoomQuery;
import com.dili.assets.mapper.TradeRoomMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;
import java.util.List;

/**
* @website http://shaofan.org
* @description 服务实现
* @author shaofan
* @date 2020-07-30
**/
@Service
@RequiredArgsConstructor
public class TradeRoomServiceImpl extends BaseServiceImpl<TradeRoom, Long> implements TradeRoomService {

    private final TradeRoomMapper tradeRoomMapper;

    @Override
    public PageInfo<TradeRoom> queryAll(TradeRoomQuery query){
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<TradeRoom> list = tradeRoomMapper.selectByQuery(query);
        PageInfo<TradeRoom> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            tradeRoomMapper.deleteByPrimaryKey(id);
        }
    }
}