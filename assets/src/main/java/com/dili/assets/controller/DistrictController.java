package com.dili.assets.controller;

import com.dili.assets.domain.District;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.service.DistrictService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@RestController
@RequestMapping("/api/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    /**
     * 新增区域
     */
    @RequestMapping("save")
    public BaseOutput save(@RequestBody District input) {
        try {
            districtService.saveDistrict(input);
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        }
        return BaseOutput.success();
    }

    /**
     * 新增区域
     */
    @RequestMapping("edit")
    public BaseOutput edit(@RequestBody District input) {
        try {
            districtService.editDistrict(input);
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        }
        return BaseOutput.success();
    }

    /**
     * 获取单个区域
     */
    @RequestMapping("get")
    public BaseOutput<District> get(@RequestBody Long id) {
        District district = districtService.get(id);
        return BaseOutput.success().setData(district);
    }

    /**
     * 删除区域
     */
    @RequestMapping("delete")
    public BaseOutput<District> delete(@RequestBody Long id) {
        try {
            districtService.delDistrict(id);
            return BaseOutput.success();
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure(e.getMessage());
        }
    }

    /**
     * 获取区域列表
     *
     * @param input
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestBody District input) {
        try {
            if (input != null && input.getIsDelete() == null) {
                input.setIsDelete(StateEnum.NO.getCode());
            }
            EasyuiPageOutput easyuiPageOutput = districtService.listEasyuiPageByExample(input, true);
//            if()
            return easyuiPageOutput.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 区域搜索
     */
    @RequestMapping("search")
    public BaseOutput<List<District>> search(@RequestBody District input) {
        try {
            if (input != null && input.getIsDelete() == null) {
                input.setIsDelete(StateEnum.NO.getCode());
            }
            return BaseOutput.success().setData(districtService.listByExample(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseOutput.success();
    }

    /**
     * 区域拆分
     *
     * @param parentId
     * @param names
     * @param notes
     * @param numbers
     * @return
     */
    @RequestMapping(value = "/divisionSave", method = RequestMethod.POST)
    public BaseOutput divisionSave(Long parentId, String[] names, String[] notes, String[] numbers) {
        districtService.division(parentId, names, notes, numbers);
        return BaseOutput.success();
    }
}