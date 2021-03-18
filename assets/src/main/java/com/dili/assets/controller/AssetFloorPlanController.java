package com.dili.assets.controller;

import com.dili.assets.domain.FloorPlan;
import com.dili.assets.service.AssetFloorPlanService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-01-28 11:17:18.
 *
 * @author asa.lee
 */
@RestController
@RequestMapping("/api/assetManagementService")
public class AssetFloorPlanController {
    @Autowired
    private AssetFloorPlanService assetManageService;


    /**
     * 获取区域
     */
    @RequestMapping("getFloorPlan")
    public BaseOutput<List<FloorPlan>> getFloorPlan(@RequestBody FloorPlan floorPlan) {
        try {
            List<FloorPlan> floorPlanList= assetManageService.getFloorPlan(floorPlan);
            return BaseOutput.success().setData(floorPlanList);
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getMessage());
        }
    }

    /**
     * 更新所有区域
     */
    @RequestMapping("updateFloorPlanData")
    public BaseOutput updateFloorPlanData(@RequestBody List<FloorPlan> fData) {
        try {
            assetManageService.updateFloorPlanData(fData);
            return BaseOutput.success();
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getMessage());
        }
    }

    /**
     * 历史快照接口
     */
    @RequestMapping("getFloorPlanHistory")
    public BaseOutput getFloorPlanHistory(@RequestBody FloorPlan floorPlan) {
        try {
            return BaseOutput.success().setData(assetManageService.getFloorPlanHistory(floorPlan));
        } catch (BusinessException e) {
            return  BaseOutput.failure(e.getMessage());
        } catch (Exception e) {
            return  BaseOutput.failure().setErrorData(e.getMessage());
        }
    }

    /**
     * 更新对应区域
     */
    @PostMapping("updateFloorPlanBoothData")
    public BaseOutput updateFloorPlanBoothData(@RequestBody FloorPlan floorPlan) {
        try {
            if(null==floorPlan||null==floorPlan.getBoothId()){
                return BaseOutput.failure("未获取到摊位号");
            }
            assetManageService.updateFloorPlanBoothData(floorPlan);
            return BaseOutput.success();
        } catch (BusinessException e) {
            return  BaseOutput.failure(e.getMessage());
        } catch (Exception e) {
            return  BaseOutput.failure().setErrorData(e.getMessage());
        }
    }
}