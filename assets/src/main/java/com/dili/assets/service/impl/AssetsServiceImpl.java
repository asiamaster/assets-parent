package com.dili.assets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dili.assets.domain.*;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.AssetsMapper;
import com.dili.assets.sdk.dto.AreaMarketQuery;
import com.dili.assets.sdk.dto.AssetsDTO;
import com.dili.assets.service.AreaMarketService;
import com.dili.assets.service.AssetsService;
import com.dili.assets.service.DistrictService;
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.BasePage;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.dto.IDTO;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.metadata.ValueProviderUtils;
import com.dili.ss.util.DateUtils;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.domain.Department;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import org.javers.core.Javers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    DataDictionaryRpc dataDictionaryRpc;

    @Autowired
    private Javers javers;

    @Autowired
    private DepartmentRpc departmentRpc;

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
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        query.setBusinessType(booth.getBusinessType());
        var check = this.listByExample(query);
        if (CollUtil.isNotEmpty(check)) {
            throw new BusinessException("5000", "摊位编号重复");
        }

        booth.setIsDelete(YesOrNoEnum.NO.getCode());
        booth.setCreateTime(new Date());
        this.saveOrUpdate(booth);
        AssetsPOJO pojo = new AssetsPOJO();
        BeanUtil.copyProperties(booth, pojo);
        javers.commit("assets", pojo);
    }

    @Override
    public String listForPage(BoothQuery input) {
        try {
            var countInput = new BoothQuery();
            if (input == null) {
                input = new BoothQuery();
            }
            BeanUtil.copyProperties(input, countInput);
            if (input.getStartTime() != null) {
                input.setStartTime(DateUtils.formatDate2DateTimeStart(input.getStartTime()));
                countInput.setStartTime(DateUtils.formatDate2DateTimeStart(input.getStartTime()));
            }
            if (input.getEndTime() != null) {
                input.setEndTime(DateUtils.formatDate2DateTimeEnd(input.getEndTime()));
                countInput.setEndTime(DateUtils.formatDate2DateTimeEnd(input.getEndTime()));
            }
            if (input.getDepartmentId() == null && StrUtil.isNotBlank(input.getDeps())) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "(department_id in (" + input.getDeps() + ") or department_id is null)");
                countInput.setMetadata(IDTO.AND_CONDITION_EXPR, "(department_id in (" + input.getDeps() + ") or department_id is null)");
            }

            if (input.getDepartmentId() == null && StrUtil.isBlank(input.getDeps())) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "department_id is null");
                countInput.setMetadata(IDTO.AND_CONDITION_EXPR, "department_id is null");
            }
            if (input.getArea() != null) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "(area = " + input.getArea() + " or second_area = " + input.getArea() + " )");
                countInput.setMetadata(IDTO.AND_CONDITION_EXPR, "(area = " + input.getArea() + " or second_area = " + input.getArea() + " )");
            }

            input.setDeps(null);
            input.setArea(null);
            countInput.setArea(null);
            countInput.setDeps(null);
            countInput.setParentId(null);
            countInput.setPage(null);
            countInput.setRows(null);
            long count = this.listByExample(countInput).size();
            boolean expand = false;
            if (input.getId() != null) {
                input.setId(null);
            }
            BasePage<Assets> boothBasePage = this.listPageByExample(input);
            var booths = boothBasePage.getDatas();
            if (input.getParentId() == null) {
                count = boothBasePage.getTotalItem();
            }
            input.setMetadata(JSON.parseObject("{\"area\":\"{\\\"provider\\\":\\\"districtProvider\\\",\\\"index\\\":20,\\\"field\\\":\\\"area\\\"}\",\"unit\":\"{\\\"provider\\\":\\\"dataDictionaryValueProvider\\\",\\\"index\\\":10,\\\"field\\\":\\\"unit\\\"}\",\"createTime\":\"{\\\"provider\\\":\\\"datetimeProvider\\\",\\\"index\\\":50,\\\"field\\\":\\\"createTime\\\"}\",\"departmentId\":\"{\\\"provider\\\":\\\"departmentProvider\\\",\\\"index\\\":40,\\\"field\\\":\\\"departmentId\\\"}\",\"state\":\"{\\\"provider\\\":\\\"boothStateProvider\\\",\\\"index\\\":60,\\\"field\\\":\\\"state\\\"}\",\"user\":\"{\\\"provider\\\":\\\"dataDictionaryValueProvider\\\",\\\"index\\\":30,\\\"field\\\":\\\"user\\\"}\"}"));
            var results = ValueProviderUtils.buildDataByProvider(input, booths);


            var result = new ArrayList();

            for (var district : results) {
                var json = JSON.parseObject(JSON.toJSONString(district));
                json.put("status", json.getString("state"));
                json.put("state", "open");
                result.add(json);
            }
            var resultJsonStr = JSONObject.toJSONString(result);
            if (expand) {
                return resultJsonStr;
            }
            var obj = new JSONObject();
            obj.put("rows", JSON.parseArray(resultJsonStr));
            obj.put("total", count);
            obj.put("footer", JSON.parseArray("[{\"name\":\"总数:" + count + "\",\"iconCls\":\"icon-sum\"}]"));
            return obj.toJSONString();
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
            var total = Arrays.stream(numbers).mapToDouble(Double::parseDouble).sum();
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
                booth.setMarketId(parent.getMarketId());
                booth.setIsDelete(StateEnum.NO.getCode());
                booth.setCreateTime(new Date());
                booth.setModifyTime(new Date());
                booth.setCreatorId(parent.getCreatorId());
                booth.setCorner(parent.getCorner());
                booth.setBusinessType(parent.getBusinessType());
                saveBooth(booth);
            }
            if (getBoothBalance(parentId) == 0) {
                parent.setIsDelete(YesOrNoEnum.YES.getCode());
                this.saveOrUpdate(parent);
            }
        }
    }

    @Override
    public List<AssetsDTO> search(BoothQuery query) {
        var result = new ArrayList<AssetsDTO>();
        query.setPage(1);
        query.setRows(100);
        if (query.getMarketId() == null) {
            return new ArrayList<>();
        }
        var list = listPageByExample(query).getDatas();
        if (query.getArea() != null && query.getSecondArea() == null) {
            list = list.stream().filter(it -> it.getSecondArea() == null).collect(Collectors.toList());
        }

        if (query.getMchId() != null) {
            AreaMarketQuery areaQuery = new AreaMarketQuery();
            areaQuery.setMarket(query.getMchId());
            var areaMarketList = areaMarketService.queryAll(areaQuery).getData();
            var mchId = areaMarketList.get(0).getArea().intValue();
            if (CollUtil.isNotEmpty(areaMarketList)) {
                list = list.stream().filter(it -> it.getArea() == mchId || it.getSecondArea() == mchId).collect(Collectors.toList());
            } else {
                return new ArrayList<>();
            }
        }

        if (CollUtil.isNotEmpty(list)) {
            var unitCache = new HashMap<String, String>();
            var disCache = new HashMap<String, String>();
            var depCache = new HashMap<String, String>();
            list.forEach(obj -> {
                AssetsDTO dto = new AssetsDTO();
                BeanUtil.copyProperties(obj, dto);

                // 转换部门
                if (dto.getDepartmentId() != null) {
                    if (depCache.containsKey(dto.getDepartmentId().toString())) {
                        dto.setDepartmentName(depCache.get(dto.getDepartmentId().toString()));
                    } else {
                        BaseOutput<Department> departmentBaseOutput = departmentRpc.get(dto.getDepartmentId().longValue());
                        Department dep = departmentBaseOutput.getData();
                        if (dep != null) {
                            dto.setDepartmentName(dep.getName());
                            depCache.put(dto.getDepartmentId().toString(), dep.getName());
                        }
                    }
                }
                // 转换单位
                if (unitCache.containsKey(obj.getUnit())) {
                    dto.setUnitName(unitCache.get(obj.getUnit()));
                } else {
                    DataDictionaryValue dataDictionaryValue = DTOUtils.newDTO(DataDictionaryValue.class);
                    dataDictionaryValue.setCode(obj.getUnit());

                    var listBaseOutput = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue);
                    List<DataDictionaryValue> data = listBaseOutput.getData();
                    for (DataDictionaryValue datum : data) {
                        if (datum.getCode().equals(obj.getUnit())) {
                            dto.setUnitName(datum.getName());
                            unitCache.put(obj.getUnit(), datum.getName());
                        }
                    }
                }
                // 转换一级区域
                if (disCache.containsKey(obj.getArea().toString())) {
                    dto.setAreaName(disCache.get(obj.getArea().toString()));
                } else {
                    District district = districtService.get(obj.getArea().longValue());
                    dto.setAreaName(district.getName());
                    disCache.put(obj.getArea().toString(), district.getName());
                }

                // 转换二级区域
                if (obj.getSecondArea() != null) {
                    if (disCache.containsKey(obj.getSecondArea().toString())) {
                        dto.setSecondAreaName(disCache.get(obj.getSecondArea().toString()));
                    } else {
                        District districtSecond = districtService.get(obj.getSecondArea().longValue());
                        dto.setSecondAreaName(districtSecond.getName());
                        disCache.put(obj.getSecondArea().toString(), districtSecond.getName());
                    }
                }

                if (obj.getCorner() != null) {
                    dto.setCornerName(obj.getCorner() == 1 ? "是" : "否");
                }
                if (query.getMchId() != null) {
                    dto.setMarketId(query.getMchId());
                } else {
                    var area = dto.getSecondArea() != null ? dto.getSecondArea() : dto.getArea();
                    AreaMarketQuery areaQuery = new AreaMarketQuery();
                    areaQuery.setArea(area.longValue());
                    var areaMarketList = areaMarketService.queryAll(areaQuery).getData();
                    if (CollUtil.isNotEmpty(areaMarketList)) {
                        dto.setMarketId(areaMarketList.get(0).getMarket());
                    } else {
                        dto.setMarketId(null);
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
        if (booth.getParentId() == 0) {
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
        return 0.0;
    }
}