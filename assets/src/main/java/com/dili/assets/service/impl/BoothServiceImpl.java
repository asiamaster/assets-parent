package com.dili.assets.service.impl;

import com.dili.assets.domain.Booth;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.mapper.BoothMapper;
import com.dili.assets.sdk.dto.BoothDTO;
import com.dili.assets.service.BoothService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@Service
public class BoothServiceImpl extends BaseServiceImpl<Booth, Long> implements BoothService {

    public BoothMapper getActualDao() {
        return (BoothMapper) getDao();
    }

    @Override
    public void saveBooth(Booth booth) {
        booth.setIsDelete(StateEnum.NO.getCode());
        booth.setCreateTime(new Date());
        booth.setState(0);
        this.saveOrUpdate(booth);
    }

    @Override
    public String listForPage(Booth input) {
        try {
            if (input == null) {
                input = new Booth();
            }
            input.setIsDelete(StateEnum.NO.getCode());
            return this.listEasyuiPageByExample(input, true).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void deleteBooth(Long id) {
        Booth booth = get(id);
        booth.setIsDelete(StateEnum.YES.getCode());
        this.updateSelective(booth);
    }

    @Override
    public void boothSplit(Long parentId, String[] names, String notes, String[] numbers) {
        if (names.length == numbers.length) {
            Booth parent = get(parentId);
            for (int i = 0; i < names.length; i++) {
                Booth booth = new Booth();
                booth.setArea(parent.getArea());
                booth.setName(names[i]);
                booth.setNumber(Double.parseDouble(numbers[i]));
                booth.setParentId(parentId);
                booth.setSecondArea(parent.getSecondArea());
                booth.setSplitNotes(notes);
                booth.setDepartmentId(parent.getDepartmentId());
                booth.setUnit(parent.getUnit());
                booth.setType(parent.getType());
                booth.setIsDelete(StateEnum.NO.getCode());
                saveBooth(booth);
            }
        } else {

        }
    }

    @Override
    public List<BoothDTO> search(BoothQuery query) {
        return null;
    }

    @Override
    public Double getBoothBalance(Long id) {
        Booth booth = get(id);
        if (booth.getParentId() == 0) {
            Booth input = new Booth();
            input.setParentId(id);
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