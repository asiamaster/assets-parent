package com.dili.assets.mapper;

import com.dili.assets.domain.FloorPlan;
import com.dili.ss.base.MyMapper;
import com.dili.ss.domain.BasePage;

import java.util.List;

/**
 * @author asa.lee
 */
public interface AssetsManageMapper extends MyMapper<FloorPlan> {
    /**
     * 更新平面图区域需要同步更新关联refId
     *
     * @param updateList
     */
    void batchUpdateRefIdByUpdate(List<FloorPlan> updateList);

    /**
     * 查询历史快照
     *
     * @param floorPlan
     * @return
     */
    List<FloorPlan> getFloorPlanHistory(FloorPlan floorPlan);
}