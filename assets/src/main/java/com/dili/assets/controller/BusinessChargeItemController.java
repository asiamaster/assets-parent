package com.dili.assets.controller;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.domain.ChargeItem;
import com.dili.assets.service.BusinessChargeItemService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.PageOutput;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-28 17:14:10.
 */
@Slf4j
@RestController
@RequestMapping("/api/businessChargeItem")
public class BusinessChargeItemController {
    @Autowired
    private BusinessChargeItemService businessChargeItemService;


    /**
     * 新增ChargeItem
     * @param businessChargeItem
     * @return BaseOutput
     */
    @RequestMapping(value="/save", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseOutput save(@Validated @RequestBody BusinessChargeItem businessChargeItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseOutput.failure(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            businessChargeItemService.saveOrUpdate(businessChargeItem);
            return BaseOutput.success("保存成功");
        } catch (Throwable t) {
            log.error(String.format("保存业务收费项信息[%s] 异常 [%s]", businessChargeItem.toString(), t.getMessage()), t);
            return BaseOutput.failure("操作失败，系统异常");
        }
    }

    /**
     * 分页查询收费项数据集
     * @param businessChargeItem
     * @return
     */
    @RequestMapping(value="/listPage", method = {RequestMethod.POST})
    public PageOutput<List<BusinessChargeItem>> listPage(@RequestBody(required = false) BusinessChargeItem businessChargeItem){
        if (Objects.isNull(businessChargeItem)){
            businessChargeItem = new BusinessChargeItem();
        }
        List<BusinessChargeItem> list = businessChargeItemService.listByExample(businessChargeItem);
        //总记录
        Long total = list instanceof Page ? ((Page) list).getTotal() : list.size();
        //总页数
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        //当前页数
        int pageNum = list instanceof Page ? ((Page) list).getPageNum() : 1;
        PageOutput output = PageOutput.success();
        output.setData(list).setPageNum(pageNum).setTotal(total.intValue()).setPageSize(businessChargeItem.getPage()).setPages(totalPage);
        return output;
    }

    /**
     * 根据ID查询某收费项信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = {RequestMethod.POST})
    public BaseOutput<BusinessChargeItem> listPage(@RequestParam("id") Long id) {
        return BaseOutput.success().setData(businessChargeItemService.get(id));
    }

    /**
     * 根据市场及业务查询对应的费用项信息
     * @param marketId   市场ID
     * @param businessType 业务类型
     * @param isEnable   是否已启用，如果为true/false，则会查询费用项本身及业务费用项都为启用/禁用 状态的数据，如果为空，则都会忽略此条件
     */
    @RequestMapping(value = "/listItemByMarketAndBusiness", method = {RequestMethod.POST})
    public BaseOutput<List<ChargeItem>> listItemByMarketAndBusiness(@RequestParam("marketId") Long marketId, @RequestParam("businessType") String businessType, @RequestParam(value = "isEnable", required = false) Boolean isEnable) {
        return BaseOutput.success().setData(businessChargeItemService.listItemByMarketAndBusiness(marketId, businessType, isEnable));
    }
}