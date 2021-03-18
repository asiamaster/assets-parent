package com.dili.assets.service.impl;/**
 * Copyright (C) DiliGroup. All Rights Reserved.
 * <p>
 * AssetManageServiceImpl created on 2021/1/28 17:41 by asa.lee
 */

import com.dili.assets.domain.Assets;
import com.dili.assets.domain.FloorPlan;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.AssetsManageMapper;
import com.dili.assets.service.AssetFloorPlanService;
import com.dili.assets.service.AssetsService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.metadata.ValueProviderUtils;
import com.dili.ss.util.DateUtils;
import com.dili.ss.util.POJOUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * TODO file description here
 *
 * @author asa.lee
 * @since 1.0
 *
 * Change History
 * Date Modifier DESC.
 * 2021/1/28 asa.lee Initial version.
 * </pre>
 */
@Service
public class AssetFloorPlanServiceImpl extends BaseServiceImpl<FloorPlan, Long> implements AssetFloorPlanService {

    @Resource
    AssetsManageMapper assetsManageMapper;
    @Autowired
    AssetsService assetsService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFloorPlanData(List<FloorPlan> fData) {
        if (CollectionUtils.isEmpty(fData)) {
            return;
        }
        FloorPlan example = fData.get(0);
        Long refId = example.getRefId();
        if (Objects.isNull(refId)) {
            return;
        }
        Integer beginVersion = 0;
        int defaultRefId = -1;
        int isPlan = 1;
        //摊位
        FloorPlan que = new FloorPlan();
        que.setItemState(StateEnum.NO.getCode());
        que.setRefId(refId);
        que.setRegionalCategory(example.getRegionalCategory());
        if (defaultRefId != refId.intValue() && isPlan != example.getRegionalCategory().intValue()) {
            que.setDistrictId(example.getDistrictId());
        }
        List<FloorPlan> floorPlans = listByExample(que);
        //获取原摊位图的version，并将原摊位过期
        if (CollectionUtils.isNotEmpty(floorPlans)) {
            Integer planVersion = floorPlans.get(0).getPlanVersion();
            beginVersion = null == planVersion ? ++beginVersion : ++planVersion;
            updateFLoorPlanState(StateEnum.YES.getCode(), example, que);
        }
        //新增摊位位置信息
        if (CollectionUtils.isNotEmpty(fData)) {
            doAddBoothFloorPlan(fData, beginVersion);
            //没有摊位信息，数据为区域信息。需要删除区域位置信息后update区域下的摊位关联id
            //更新维度为区域时、更新区域下的摊位号关联id
            if (Objects.isNull(que.getDistrictId())) {
                updateOldRefId(floorPlans, fData);
            }
        }
    }

    @Override
    public EasyuiPageOutput getFloorPlanHistory(FloorPlan floorPlan) throws Exception {
        if (floorPlan.getRows() != null && floorPlan.getRows() >= 1) {
            PageHelper.startPage(floorPlan.getPage(), floorPlan.getRows());
        }
        if (StringUtils.isNotBlank(floorPlan.getSort())) {
            floorPlan.setSort(POJOUtils.humpToLineFast(floorPlan.getSort()));
        }
        List<FloorPlan> historyList = assetsManageMapper.getFloorPlanHistory(floorPlan);
        long total = historyList instanceof Page ? ((Page) historyList).getTotal() : (long) historyList.size();
        List results = ValueProviderUtils.buildDataByProvider(floorPlan, historyList);
        return new EasyuiPageOutput(total, results);
    }

    @Override
    public void updateFloorPlanBoothData(FloorPlan floorPlan) {
        Assets booth = assetsService.get(floorPlan.getBoothId());
        if (null != booth) {
            FloorPlan up = new FloorPlan();
            up.setPlanText(booth.getName());
            up.setBoothName(booth.getName());
            if (StateEnum.YES.getCode().equals(booth.getIsDelete())) {
                up.setItemState(StateEnum.YES.getCode());
            }
            /*up.setBoothState(booth.getState());
            up.setBoothRentState(booth.get);*/
            FloorPlan con = new FloorPlan();
            con.setBoothId(floorPlan.getBoothId());
            con.setItemState(StateEnum.NO.getCode());
            updateSelectiveByExample(up, con);
        }
    }

    @Override
    public List<FloorPlan> getFloorPlan(FloorPlan floorPlan) {
        return listByExample(floorPlan);
    }

    /**
     * 更新区域关联id-refId
     *
     * @param oldFloorPlans
     * @param floorPlanList
     */
    private void updateOldRefId(List<FloorPlan> oldFloorPlans, List<FloorPlan> floorPlanList) {
        Map<Long, Long> newRefMap = floorPlanList.stream().collect(Collectors.toMap(FloorPlan::getDistrictId, FloorPlan::getId,(a,b)->a));
        if (CollectionUtils.isNotEmpty(oldFloorPlans)) {
            oldFloorPlans.stream().forEach(up ->
            {
                Long newRefId = newRefMap.get(up.getDistrictId());
                up.setNewRefId(newRefId);
            });
            assetsManageMapper.batchUpdateRefIdByUpdate(oldFloorPlans);
        }
    }

    /**
     * 新增区域图数据
     *
     * @param fData
     * @param beginVersion
     * @return
     */
    private List<FloorPlan> doAddBoothFloorPlan(List<FloorPlan> fData, Integer beginVersion) {
        Integer finalBeginVersion = beginVersion;
        fData.stream().forEach(f -> {
            f.setPlanVersion(finalBeginVersion);
            f.setItemState(StateEnum.NO.getCode());
            f.setCreateTime(DateUtils.getCurrentDate());
            f.setModifyTime(DateUtils.getCurrentDate());
        });
        batchInsert(fData);
        return fData;
    }

    /**
     * 根据条件更新区域状态
     *
     * @param code
     * @param example
     * @param que
     */
    private void updateFLoorPlanState(Integer code, FloorPlan example, FloorPlan que) {
        //将历史的图形改为过期/删除
        FloorPlan updateStateF = new FloorPlan();
        updateStateF.setItemState(code);
        updateStateF.setUpdateNotes(example.getUpdateNotes());
        updateSelectiveByExample(updateStateF, que);
    }
}
