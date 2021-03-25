package com.dili.assets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dili.assets.domain.AreaMarket;
import com.dili.assets.domain.Assets;
import com.dili.assets.domain.District;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.AssetsMapper;
import com.dili.assets.sdk.dto.AreaMarketQuery;
import com.dili.assets.sdk.dto.AssetsDTO;
import com.dili.assets.sdk.dto.AssetsPOJO;
import com.dili.assets.service.AreaMarketService;
import com.dili.assets.service.AssetsService;
import com.dili.assets.service.DistrictService;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.BasePage;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.dto.IDTO;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.metadata.ValueProviderUtils;
import com.dili.ss.util.DateUtils;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.domain.Department;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import lombok.val;
import org.javers.core.Javers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@Service
public class AssetsServiceImpl extends BaseServiceImpl<Assets, Long> implements AssetsService {

    private final static Logger LOG = LoggerFactory.getLogger(AssetsServiceImpl.class);

    @Autowired
    private AmqpTemplate template;

    @Autowired
    DataDictionaryRpc dataDictionaryRpc;

    @Autowired
    private Javers javers;

    @Autowired
    private DistrictService districtService;

    @Autowired
    public AreaMarketService areaMarketService;

    public AssetsMapper getActualDao() {
        return (AssetsMapper) getDao();
    }

    @Override
    @Transactional
    public void saveBooth(Assets booth) {
        var query = new Assets();
        query.setName(booth.getName());
        query.setBusinessType(booth.getBusinessType());
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        query.setMarketId(booth.getMarketId());
        query.setArea(booth.getArea());
        query.setSecondArea(booth.getSecondArea());
        var check = this.listByExample(query);
        if (CollUtil.isNotEmpty(check)) {
            throw new BusinessException("5000", "资产编号重复");
        }

        booth.setIsDelete(YesOrNoEnum.NO.getCode());
        booth.setCreateTime(new Date());
        this.saveOrUpdate(booth);
    }

    @Override
    public String listForPage(BoothQuery input) {
        try {
            if (input == null) {
                input = new BoothQuery();
            }
            if (input.getStartTime() != null) {
                input.setStartTime(DateUtils.formatDate2DateTimeStart(input.getStartTime()));
            }
            if (input.getEndTime() != null) {
                input.setEndTime(DateUtils.formatDate2DateTimeEnd(input.getEndTime()));
            }

            String condition = "";
            if (input.getArea() != null) {
                condition = "(area = " + input.getArea() + " or second_area = " + input.getArea() + " )";
                input.setArea(null);
            }

            if (input.getDepartmentId() == null && StrUtil.isNotBlank(input.getDeps())) {
                if (StrUtil.isNotBlank(condition)) {
                    condition = condition + " and " + "(concat(',',department_id, ',') regexp concat(',',replace('" + input.getDeps() + "',',',',|,'),',') = 1  or department_id is null or department_id = '')";
                } else {
                    condition = "(concat(',',department_id, ',') regexp concat(',',replace('" + input.getDeps() + "',',',',|,'),',') = 1  or department_id is null or department_id = '')";
                }
                input.setDeps(null);
            }

            if (StrUtil.isNotBlank(condition)) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, condition);
            }

            EasyuiPageOutput easyuiPageOutput = this.listEasyuiPageByExample(input, true);
            return easyuiPageOutput.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void deleteBooth(Long id) {
        var booth = get(id);
        booth.setIsDelete(YesOrNoEnum.YES.getCode());
        var input = new Assets();
        input.setParentId(id);
        input.setIsDelete(YesOrNoEnum.NO.getCode());
        var booths = this.listByExample(input);

        if (CollUtil.isNotEmpty(booths)) {
            throw new BusinessException("500", "不能删除父摊位");
        }
        this.updateSelective(booth);
    }

    @Override
    @Transactional
    public void boothSplit(Long parentId, String[] names, String notes, String[] numbers) {
        if (names == null || numbers == null) {
            return;
        }

        if (names.length == numbers.length) {
            var parent = get(parentId);
            for (int i = 0; i < names.length; i++) {
                var booth = new Assets();
                booth.setArea(parent.getArea());
                booth.setName(names[i]);
                booth.setNumber(Double.parseDouble(numbers[i]));
                booth.setParentId(parentId);
                booth.setFloor(parent.getFloor());
                booth.setUser(parent.getUser());
                booth.setSecondArea(parent.getSecondArea());
                booth.setNotes(notes);
                booth.setDepartmentId(parent.getDepartmentId());
                booth.setUnit(parent.getUnit());
                booth.setType(parent.getType());
                booth.setState(1);
                booth.setMarketId(parent.getMarketId());
                booth.setIsDelete(StateEnum.NO.getCode());
                booth.setCreateTime(new Date());
                booth.setModifyTime(new Date());
                booth.setCreatorId(parent.getCreatorId());
                booth.setCorner(parent.getCorner());
                booth.setBusinessType(parent.getBusinessType());
                booth.setSale(YesOrNoEnum.NO.getCode());
                booth.setSelf(YesOrNoEnum.NO.getCode());
                saveBooth(booth);
                AssetsPOJO pojo = new AssetsPOJO();
                BeanUtil.copyProperties(booth, pojo);
                Map<String, String> prep = new HashMap<>();
                prep.put("notes", "由资产：" + parent.getName() + " 拆分出来");
                javers.commit("assets", pojo, prep);
            }
            if (getBoothBalance(parentId) == 0) {
                parent.setIsDelete(YesOrNoEnum.YES.getCode());
                this.saveOrUpdate(parent);
                try {
                    template.convertAndSend("exchange", "assets.delete", parent.getId());
                } catch (Exception ignored) {
                }
            }
        }
    }

    @Override
    public List<AssetsDTO> search(BoothQuery query) {
        var result = new ArrayList<AssetsDTO>();
        query.setPage(1);
        query.setRows(100);

        if (query.getDepartmentId() == null && StrUtil.isNotBlank(query.getDeps())) {
            query.setMetadata(IDTO.AND_CONDITION_EXPR, "(concat(',',department_id, ',') regexp concat(',',replace('" + query.getDeps() + "',',',',|,'),',') = 1  or department_id is null or department_id = '')");
            query.setDeps(null);
        }

        var list = listPageByExample(query).getDatas();
        if (query.isOnlyFirstArea() && query.getArea() != null && query.getSecondArea() == null) {
            list = list.stream().filter(it -> it.getSecondArea() == null).collect(Collectors.toList());
        }

        if (query.getMchId() != null) {
            AreaMarketQuery areaQuery = new AreaMarketQuery();
            areaQuery.setMarket(query.getMchId());
            var areaMarketList = areaMarketService.queryAll(areaQuery).getData();
            List<Integer> areas = areaMarketList.stream().map(o -> o.getArea().intValue()).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(areaMarketList)) {
                list = list.stream().filter(it ->
                        areas.contains(it.getSecondArea()) || (it.getSecondArea() == null && areas.contains(it.getArea())))
                        .collect(Collectors.toList());
            } else {
                return new ArrayList<>();
            }
        }

        if (CollUtil.isNotEmpty(list)) {
            DataDictionaryValue dataDictionaryValue = DTOUtils.newDTO(DataDictionaryValue.class);
            dataDictionaryValue.setDdCode("unit");
            dataDictionaryValue.setFirmId(query.getMarketId());
            List<DataDictionaryValue> dataDictionaryValues = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue).getData();
            District district = new District();
            district.setMarketId(query.getMarketId());
            List<District> districts = districtService.listByExample(district);
            List<AreaMarket> areaMarkets = areaMarketService.queryAll(null).getData();
            list.forEach(obj -> {
                AssetsDTO dto = new AssetsDTO();
                BeanUtil.copyProperties(obj, dto);

                // 转换单位
                if (CollUtil.isNotEmpty(dataDictionaryValues)) {
                    dataDictionaryValues.stream().filter(it -> it.getCode().equals(dto.getUnit()))
                            .findFirst().ifPresent(it -> dto.setUnitName(it.getName()));
                }

                // 转换一级区域
                districts.stream().filter(it -> it.getId().intValue() == dto.getArea())
                        .findFirst().ifPresent(it -> dto.setAreaName(it.getName()));

                // 转换二级区域
                if (obj.getSecondArea() != null) {
                    districts.stream().filter(it -> it.getId().intValue() == dto.getSecondArea())
                            .findFirst().ifPresent(it -> dto.setSecondAreaName(it.getName()));
                }

                if (obj.getCorner() != null) {
                    dto.setCornerName(obj.getCorner() == 1 ? "是" : "否");
                }
                if (query.getMchId() != null) {
                    dto.setMchId(query.getMchId());
                } else {
                    if (CollUtil.isNotEmpty(areaMarkets)) {
                        var area = dto.getSecondArea() != null ? dto.getSecondArea() : dto.getArea();
                        areaMarkets.stream().filter(it -> it.getArea().intValue() == area)
                                .findFirst().ifPresent(it -> dto.setMchId(it.getMarket()));
                    }
                }
                result.add(dto);
            });
        }
        return result;
    }

    @Override
    public Double getBoothBalance(Long id) {
        Assets booth = get(id);
        Assets input = new Assets();
        input.setParentId(id);
        input.setIsDelete(YesOrNoEnum.NO.getCode());
        List<Assets> booths = this.listByExample(input);

        var ref = new Object() {
            Double number = 0D;
        };
        booths.forEach(obj -> ref.number += obj.getNumber());
        return booth.getNumber() - ref.number;
    }

    @Override
    public int updateStateByIdIn(Collection<Long> idList) {
        return getActualDao().updateStateByIdIn(idList);
    }
}