package com.dili.assets.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dili.assets.domain.Booth;
import com.dili.assets.domain.BoothRent;
import com.dili.assets.domain.District;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.BoothMapper;
import com.dili.assets.sdk.dto.BoothDTO;
import com.dili.assets.service.BoothService;
import com.dili.assets.service.DistrictService;
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.dto.IDTO;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.metadata.ValueProviderUtils;
import com.dili.ss.util.DateUtils;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@Service
public class BoothServiceImpl extends BaseServiceImpl<Booth, Long> implements BoothService {

    private final static Logger LOG = LoggerFactory.getLogger(BoothServiceImpl.class);

    @Autowired
    DataDictionaryRpc dataDictionaryRpc;

    @Autowired
    private DepartmentRpc departmentRpc;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private BoothRentServiceImpl boothRentService;

    public BoothMapper getActualDao() {
        return (BoothMapper) getDao();
    }

    @Override
    @Transactional
    public void saveBooth(Booth booth) {
        Booth query = new Booth();
        query.setName(booth.getName());
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        List<Booth> check = this.listByExample(query);
        if (CollUtil.isNotEmpty(check)) {
            throw new BusinessException("5000", "摊位编号重复");
        }

        booth.setIsDelete(YesOrNoEnum.NO.getCode());
        booth.setCreateTime(new Date());
        booth.setState(EnabledStateEnum.ENABLED.getCode());
        this.saveOrUpdate(booth);
    }

    @Override
    public String listForPage(BoothQuery input) {
        try {
            if (input == null) {
                input = new BoothQuery();
            }
            input.setIsDelete(StateEnum.NO.getCode());
            if (input.getStartTime() != null) {
                input.setStartTime(DateUtils.formatDate2DateTimeStart(input.getStartTime()));
            }
            if (input.getEndTime() != null) {
                input.setEndTime(DateUtils.formatDate2DateTimeEnd(input.getEndTime()));
            }
            if (input.getDepartmentId() == null && StrUtil.isNotBlank(input.getDeps())) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "(department_id in (" + input.getDeps() + ") or department_id is null)");
            }

            if(input.getDepartmentId() == null && StrUtil.isBlank(input.getDeps())){
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "department_id is null");
            }
            input.setDeps(null);
            EasyuiPageOutput easyuiPageOutput = this.listEasyuiPageByExample(input, false);
            List rows = easyuiPageOutput.getRows();
            int count = 0;
            if (CollUtil.isNotEmpty(rows)) {
                List<Long> child = new ArrayList();
                rows.forEach(obj -> {
                    Booth booth = (Booth) obj;
                    Long parentId = booth.getParentId();
                    if (parentId != 0) {
                        if (!child.contains(parentId)) {
                            child.add(parentId);
                        }
                    }
                });
                for (Long booth : child) {
                    boolean anyMatch = rows.stream().anyMatch(o -> {
                        Booth d = (Booth) o;
                        return d.getId().equals(booth);
                    });
                    if (!anyMatch) {
                        count++;
                        rows.add(this.get(booth));
                    }
                }
            }
            easyuiPageOutput.setTotal(easyuiPageOutput.getTotal() + count);
            List results = ValueProviderUtils.buildDataByProvider(input, rows);
            return new EasyuiPageOutput(Integer.parseInt(String.valueOf(easyuiPageOutput.getTotal())), results).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void deleteBooth(Long id) {
        Booth booth = get(id);
        booth.setIsDelete(YesOrNoEnum.YES.getCode());
        Booth input = new Booth();
        input.setParentId(id);
        input.setIsDelete(YesOrNoEnum.NO.getCode());
        List<Booth> booths = this.listByExample(input);

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
        Booth queryBooth = new Booth();
        queryBooth.setParentId(parentId);
        queryBooth.setIsDelete(YesOrNoEnum.NO.getCode());
        List<Booth> booths = this.listByExample(queryBooth);
        if (CollUtil.isNotEmpty(booths)) {
            for (Booth booth : booths) {
                BoothRent boothRent = new BoothRent();
                boothRent.setBoothId(booth.getId());
                List<BoothRent> boothRents = boothRentService.listByExample(boothRent);
                if (CollUtil.isNotEmpty(boothRents)) {
                    throw new BusinessException("5000", "摊位已有租赁，不能拆分");
                }
            }
        }
        BoothRent boothRent = new BoothRent();
        boothRent.setBoothId(parentId);
        List<BoothRent> boothRents = boothRentService.listByExample(boothRent);
        if (CollUtil.isNotEmpty(boothRents)) {
            throw new BusinessException("5000", "摊位已有租赁，不能拆分");
        }
        if (names.length == numbers.length) {
            Booth parent = get(parentId);
            if (parent.getState().equals(EnabledStateEnum.DISABLED.getCode()) || parent.getIsDelete().equals(YesOrNoEnum.YES.getCode())) {
                throw new BusinessException("5000", "摊位禁用或删除，不能拆分");
            }
            for (int i = 0; i < names.length; i++) {
                Booth booth = new Booth();
                booth.setArea(parent.getArea());
                booth.setName(names[i]);
                booth.setNumber(Double.parseDouble(numbers[i]));
                booth.setParentId(parentId);
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
                saveBooth(booth);
            }
        }
    }

    @Override
    public List<BoothDTO> search(BoothQuery query) {
        List<BoothDTO> result = new ArrayList<>();
        List<Booth> list = listByExample(query);
        if (CollUtil.isNotEmpty(list)) {
            list.forEach(obj -> {
                BoothDTO dto = new BoothDTO();
                BeanUtil.copyProperties(obj, dto);
                // 转换单位
                DataDictionaryValue dataDictionaryValue = DTOUtils.newDTO(DataDictionaryValue.class);
                dataDictionaryValue.setCode(obj.getUnit());

                BaseOutput<List<DataDictionaryValue>> listBaseOutput = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue);
                List<DataDictionaryValue> data = listBaseOutput.getData();
                for (DataDictionaryValue datum : data) {
                    if (datum.getCode().equals(obj.getUnit())) {
                        dto.setUnitName(datum.getName());
                    }
                }
                // 转换一级区域
                District district = districtService.get(obj.getArea().longValue());
                dto.setAreaName(district.getName());
                // 转换二级区域
                if (obj.getSecondArea() != null) {
                    District districtSecond = districtService.get(obj.getSecondArea().longValue());
                    dto.setSecondAreaName(districtSecond.getName());
                }
                if (obj.getCorner() != null) {
                    dto.setCornerName(obj.getCorner() == 1 ? "是" : "否");
                }
                result.add(dto);
            });
        }
        return result;
    }

    @Override
    public Double getBoothBalance(Long id) {
        Booth booth = get(id);
        if (booth.getParentId() == 0) {
            Booth input = new Booth();
            input.setParentId(id);
            input.setIsDelete(YesOrNoEnum.NO.getCode());
            List<Booth> booths = this.listByExample(input);

            var ref = new Object() {
                Double number = 0D;
            };
            booths.forEach(obj -> ref.number += obj.getNumber());
            return booth.getNumber() - ref.number;
        }
        return 0.0;
    }
}