package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.District;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.DistrictMapper;
import com.dili.assets.service.BoothService;
import com.dili.assets.service.DistrictService;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@Service
public class DistrictServiceImpl extends BaseServiceImpl<District, Long> implements DistrictService {

    public DistrictMapper getActualDao() {
        return (DistrictMapper) getDao();
    }

    @Autowired
    private BoothService boothService;

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
        District parent = this.get(parentId);
        for (int i = 0; i < names.length; i++) {
            District cond = new District();
            cond.setName(names[i]);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            List<District> districts = this.listByExample(cond);
            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "编号已存在");
            }

            cond = new District();
            cond.setDepartmentId(parent.getDepartmentId());
            cond.setName(names[i]);
            cond.setIsDelete(StateEnum.NO.getCode());
            cond.setMarketId(parent.getMarketId());
            districts = this.listByExample(cond);

            if (CollUtil.isNotEmpty(districts)) {
                throw new BusinessException("1", "该部门下区域已存在");
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
                    district.setNumber(StringUtils.trimToNull(numbers[i]));
                }
                district.setDepartmentId(parent.getDepartmentId());
                district.setMarketId(parent.getMarketId());

                this.saveOrUpdate(district);
            }
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
}