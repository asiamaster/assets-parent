package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.nacos.api.config.ConfigService;
import com.dili.assets.domain.AreaMarket;
import com.dili.assets.domain.Config;
import com.dili.assets.domain.District;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.ConfigMapper;
import com.dili.assets.mapper.DistrictMapper;
import com.dili.assets.sdk.dto.ConfigQuery;
import com.dili.assets.service.AreaMarketService;
import com.dili.assets.service.AssetsService;
import com.dili.assets.service.DistrictService;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import com.dili.uap.sdk.domain.Firm;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.dili.uap.sdk.rpc.FirmRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@Service
@Slf4j
public class DistrictServiceImpl extends BaseServiceImpl<District, Long> implements DistrictService {

    public DistrictMapper getActualDao() {
        return (DistrictMapper) getDao();
    }

    private final String AREA_DEFAULT_MCH = "areaIsDefaultMch";


    @Autowired
    private AssetsService boothService;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private AreaMarketService areaMarketService;

    @Override
    public void saveDistrict(District input) {
        District cond = new District();
        cond.setNumber(input.getNumber());
        cond.setIsDelete(StateEnum.NO.getCode());
        cond.setMarketId(input.getMarketId());
        List<District> districts = this.listByExample(cond);
        if (CollUtil.isNotEmpty(districts)) {
            throw new BusinessException("1", "编号已存在");
        }
        input.setIsDelete(StateEnum.NO.getCode());

        cond = new District();
        cond.setDepartmentId(input.getDepartmentId());
        cond.setName(input.getName());
        cond.setIsDelete(StateEnum.NO.getCode());
        cond.setMarketId(input.getMarketId());
        districts = this.listByExample(cond);

        if (CollUtil.isNotEmpty(districts)) {
            throw new BusinessException("1", "该部门下区域已存在");
        }
        input.setIsDelete(StateEnum.NO.getCode());
        this.insert(input);
        saveAreaMarket(input);
    }

    @Override
    public void editDistrict(District input) {
        District cond = new District();
        cond.setNumber(input.getNumber());
        cond.setIsDelete(StateEnum.NO.getCode());
        cond.setMarketId(input.getMarketId());
        List<District> districts = this.listByExample(cond);
        if (CollUtil.isNotEmpty(districts) && !districts.get(0).getId().equals(input.getId())) {
            throw new BusinessException("1", "编号已存在");
        }

        cond = new District();
        cond.setDepartmentId(input.getDepartmentId());
        cond.setName(input.getName());
        cond.setIsDelete(StateEnum.NO.getCode());
        cond.setMarketId(input.getMarketId());
        districts = this.listByExample(cond);

        if (CollUtil.isNotEmpty(districts) && !districts.get(0).getId().equals(input.getId())) {
            throw new BusinessException("1", "该部门下区域已存在");
        }
        this.updateSelective(input);
    }

    @Override
    public void division(Long parentId, String[] names, String[] notes, String[] numbers) {
        List<Integer> duplicate = Arrays.stream(names).collect(Collectors.toMap(e -> e, e -> 1, Integer::sum)).values().stream().filter(e -> e > 1).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(duplicate)) {
            throw new BusinessException("1", "区域已存在");
        }
        List<Integer> duplicateNumber = Arrays.stream(numbers).collect(Collectors.toMap(e -> e, e -> 1, Integer::sum)).values().stream().filter(e -> e > 1).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(duplicateNumber)) {
            throw new BusinessException("1", "编号已存在");
        }
        District parent = this.get(parentId);
        for (String name : names) {
            District cond = new District();
            cond.setName(name);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            List<District> districts = this.listByExample(cond);
            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "区域已存在");
            }
            cond = new District();
            cond.setDepartmentId(parent.getDepartmentId());
            cond.setName(name);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            districts = this.listByExample(cond);

            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "该部门下区域已存在");
            }
        }

        for (String s : numbers) {
            District cond = new District();
            cond.setNumber(s);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            List<District> districts = this.listByExample(cond);
            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "编号已存在");
            }

            cond = new District();
            cond.setDepartmentId(parent.getDepartmentId());
            cond.setNumber(s);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            districts = this.listByExample(cond);

            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "该部门下编号已存在");
            }
        }
        for (int i = 0; i < names.length; i++) {
            if (StringUtils.isNotBlank(names[i])) {
                int j = i + 1;
                District district = new District();
                district.setCreateTime(new Date());
                district.setIsDelete(StateEnum.NO.getCode());
                district.setModifyTime(new Date());
                district.setParentId(parentId);
                district.setName(names[i]);

                if (notes.length > 0) {
                    district.setNotes(notes[i]);
                }
                if (numbers.length > 0) {
                    String number = StringUtils.trimToNull(numbers[i]);
                    district.setNumber(number);
                }
                district.setDepartmentId(parent.getDepartmentId());
                district.setKind(parent.getKind());
                district.setMarketId(parent.getMarketId());

                this.saveOrUpdate(district);

                saveAreaMarket(district);
            }
        }
    }

    private void saveAreaMarket(District district) {
        try {
            ConfigQuery query = new ConfigQuery();
            query.setMarketId(district.getMarketId());
            query.setName(AREA_DEFAULT_MCH);
            List<Config> configs = configMapper.selectByQuery(query);
            if (CollUtil.isEmpty(configs)) {
                AreaMarket areaMarket = new AreaMarket();
                areaMarket.setMarket(district.getMarketId());
                areaMarket.setArea(district.getId());
                areaMarketService.insert(areaMarket);
            }
        } catch (Exception e) {
            log.error("保存商户区域报错", e);
        }
    }

    @Override
    public void delDistrict(Long id) {
        BoothQuery query = new BoothQuery();
        query.setArea(id.intValue());
        if (CollUtil.isNotEmpty(boothService.listByExample(query))) {
            throw new BusinessException("500", "该区域被使用无法删除");
        }
        query = new BoothQuery();
        query.setSecondArea(id.intValue());
        if (CollUtil.isNotEmpty(boothService.listByExample(query))) {
            throw new BusinessException("500", "该区域被使用无法删除");
        }
        District check = new District();
        check.setParentId(id);
        check.setIsDelete(YesOrNoEnum.NO.getCode());
        List<District> districts = listByExample(check);
        if (CollUtil.isNotEmpty(districts)) {
            throw new BusinessException("500", "父区域无法删除");
        }
        for (District district : districts) {
            query = new BoothQuery();
            query.setSecondArea(district.getId().intValue());
            if (CollUtil.isNotEmpty(boothService.listByExample(query))) {
                throw new BusinessException("500", "该区域被使用无法删除");
            }
        }


        District condition = new District();
        condition.setId(id);
        condition.setIsDelete(StateEnum.YES.getCode());
        updateSelective(condition);

        District district = get(id);
        if (district != null && district.getParentId() == 0) {
            condition = new District();
            condition.setIsDelete(StateEnum.YES.getCode());
            condition.setParentId(id);
            childrenUpdateByPid(condition);
        }
    }

    @Override
    public void childrenUpdateByPid(District update) {
        getActualDao().childrenUpdateByPid(update);
    }

    @Override
    public List<District> selectByAreaMarket(Long id) {
        return getActualDao().selectByAreaMarket(id);
    }
}