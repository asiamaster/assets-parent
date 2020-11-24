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

import com.dili.assets.domain.Floor;
import com.dili.ss.domain.BaseOutput;
import lombok.RequiredArgsConstructor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dili.assets.service.FloorService;
import com.dili.assets.sdk.dto.FloorQuery;
import com.dili.assets.mapper.FloorMapper;
import org.springframework.stereotype.Service;
import com.dili.ss.base.BaseServiceImpl;
import java.util.List;

/**
* @website http://shaofan.org
* @description 服务实现
* @author shaofan
* @date 2020-11-23
**/
@Service
@RequiredArgsConstructor
public class FloorServiceImpl extends BaseServiceImpl<Floor, Long> implements FloorService {

    private final FloorMapper floorMapper;

    @Override
    public PageInfo<Floor> query(FloorQuery query){
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Floor> list = floorMapper.selectByQuery(query);
        PageInfo<Floor> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseOutput<List<Floor>> queryAll(FloorQuery query){
        List<Floor> list = floorMapper.selectByQuery(query);
        return BaseOutput.successData(list);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            floorMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void enableAll(Long[] ids) {
        for (Long id : ids) {
            System.out.println("自行实现批量启用");
        }
    }

    @Override
    public void disableAll(Long[] ids) {
        for (Long id : ids) {
            System.out.println("自行实现批量禁用");
        }
    }

    @Override
    public BaseOutput saveFloor(Floor floor) {
        this.saveOrUpdate(floor);
        return BaseOutput.success();
    }

    @Override
    public BaseOutput updateFloor(Floor floor) {
        this.updateSelective(floor);
        return BaseOutput.success();
    }
}