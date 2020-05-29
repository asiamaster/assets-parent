package com.dili.assets.controller;

import com.dili.assets.domain.ChargeItem;
import com.dili.assets.service.ChargeItemService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-26 18:24:30.
 */
@RestController
@RequestMapping("/api/chargeItem")
public class ChargeItemController {

    @Autowired
    private ChargeItemService chargeItemService;

    /**
     * 新增ChargeItem
     * @param chargeItem
     * @return BaseOutput
     */
    @RequestMapping(value="/save", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseOutput save(@Validated @RequestBody ChargeItem chargeItem) {
        chargeItemService.saveOrUpdate(chargeItem);
        return BaseOutput.success("新增成功");
    }

    /**
     * 分页查询收费项数据集
     * @param chargeItem
     * @return
     */
    @RequestMapping(value="/listPage", method = {RequestMethod.POST})
    public BaseOutput<List<ChargeItem>> listPage(@RequestBody(required = false) ChargeItem chargeItem){
        return BaseOutput.success().setData(chargeItemService.listByExample(chargeItem));
    }

    /**
     * 根据ID查询某收费项信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = {RequestMethod.POST})
    public BaseOutput<ChargeItem> listPage(@RequestParam("id") Long id) {
        return BaseOutput.success().setData(chargeItemService.get(id));
    }
}