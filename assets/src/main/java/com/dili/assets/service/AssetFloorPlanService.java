package com.dili.assets.service;

import com.dili.assets.domain.FloorPlan;
import com.dili.ss.base.BaseService;
import com.dili.ss.domain.EasyuiPageOutput;

import java.util.List;

/**
 * Copyright (C) DiliGroup. All Rights Reserved.
 * <p>
 * AssetManageService created on 2021/1/28 17:08 by asa.lee
 *
 * @author asa.lee
 */
public interface AssetFloorPlanService extends BaseService<FloorPlan, Long> {
    /**
     * 更新区域图数据
     *
     * @param fData
     */
    void updateFloorPlanData(List<FloorPlan> fData);

    /**
     * 获取历史记录
     *
     * @param floorPlan
     * @return
     */
    EasyuiPageOutput getFloorPlanHistory(FloorPlan floorPlan) throws Exception;

    /**
     * 同步摊位信息到平面图
     * @param boothId
     */
    void updateFloorPlanBoothData(FloorPlan boothId);

    /**
     * 获取摊位列表
     * @return
     * @param floorPlan
     */
    List<FloorPlan> getFloorPlan(FloorPlan floorPlan);
}
