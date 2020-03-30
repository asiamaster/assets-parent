package com.dili.assets.controller;

import com.dili.assets.domain.Booth;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.sdk.dto.BoothDTO;
import com.dili.assets.service.BoothService;
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@RestController
@RequestMapping("/api/booth")
public class BoothController {
    @Autowired
    BoothService boothService;

    /**
     * 新增摊位
     *
     * @param booth
     * @return
     */
    @RequestMapping("save")
    public BaseOutput save(@RequestBody Booth booth) {
        boothService.saveBooth(booth);
        return BaseOutput.success();
    }

    /**
     * 搜索摊位
     */
    @RequestMapping("search")
    public BaseOutput<List<BoothDTO>> search(@RequestBody BoothQuery query) {
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        query.setState(EnabledStateEnum.ENABLED.getCode());
        return BaseOutput.success().setData(boothService.search(query));
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @RequestMapping("get")
    public BaseOutput<Booth> get(@RequestBody Long id) {
        return BaseOutput.success().setData(boothService.get(id));
    }

    /**
     * 新增摊位
     *
     * @param booth
     * @return
     */
    @RequestMapping("update")
    public BaseOutput update(@RequestBody Booth booth) {
        boothService.updateSelective(booth);
        return BaseOutput.success();
    }

    /**
     * 获取摊位列表
     *
     * @param booth
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestBody BoothQuery booth) {
        return boothService.listForPage(booth);
    }

    /**
     * 获取摊位剩余面积
     */
    @RequestMapping("getBoothBalance")
    public BaseOutput<Double> getBoothBalance(@RequestBody Long id) {
        return BaseOutput.success().setData(boothService.getBoothBalance(id));
    }

    /**
     * 删除摊位
     */
    @RequestMapping("delete")
    public BaseOutput delete(@RequestBody Long id) {
        try {
            boothService.deleteBooth(id);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getErrorMsg());
        }
        return BaseOutput.success();
    }

    /**
     * 摊位拆分
     */
    @RequestMapping(value = "/split", method = RequestMethod.POST)
    public BaseOutput boothSplit(Long parentId, String[] names, String notes, String[] numbers) {
        boothService.boothSplit(parentId, names, notes, numbers);
        return BaseOutput.success();
    }
}