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

import com.dili.assets.domain.Floor;
import com.dili.assets.service.FloorService;
import com.dili.assets.sdk.dto.FloorQuery;
import com.dili.assets.sdk.dto.FloorDto;
import lombok.RequiredArgsConstructor;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.dili.commons.bstable.TableResult;

/**
* @website http://shaofan.org
* @author shaofan
* @date 2020-11-23
**/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/floor")
public class FloorController {

    private final FloorService floorService;

    /**
     * 查询数据分页
     * @param query 条件
     * @return PageInfo<Floor>
     */
    @PostMapping("/query")
    public Object query(@RequestBody FloorQuery query){
        PageInfo<Floor> page = floorService.query(query);
        TableResult<Floor> result = new TableResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 查询所有数据
     * @param query 条件
     */
    @PostMapping("/queryAll")
    public Object queryAll(@RequestBody FloorQuery query){
        return floorService.queryAll(query);
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Object add(@RequestBody Floor floor){
        floorService.saveFloor(floor);
        return BaseOutput.success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody Floor floor){
        floorService.updateFloor(floor);
        return BaseOutput.success();
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public BaseOutput<FloorDto> get(@RequestBody Long id) {
        return BaseOutput.success().setData(floorService.get(id));
    }

    /**
     * 多选删除
     */
    @PostMapping("/deleteAll")
    public BaseOutput deleteAll(@RequestBody Long[] ids) {
        floorService.deleteAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选启用
     */
    @PostMapping("/enableAll")
    public BaseOutput enableAll(@RequestBody Long[] ids) {
        floorService.enableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 多选禁用
     */
    @PostMapping("/disableAll")
    public BaseOutput disableAll(@RequestBody Long[] ids) {
        floorService.disableAll(ids);
        return BaseOutput.success();
    }

    /**
     * 删除区域下楼层
     */
    @PostMapping("/deleteByArea")
    public BaseOutput deleteByArea(@RequestBody Long areaId) {
        Floor floor = new Floor();
        floor.setArea(areaId);
        floorService.deleteByExample(floor);
        return BaseOutput.success();
    }
}