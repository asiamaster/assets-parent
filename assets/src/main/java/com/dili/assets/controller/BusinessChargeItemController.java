package com.dili.assets.controller;

import com.dili.assets.domain.BusinessChargeItem;
import com.dili.assets.domain.query.BusinessChargeItemQuery;
import com.dili.assets.service.BusinessChargeItemService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.PageOutput;
import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-28 17:14:10.
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/businessChargeItem")
public class BusinessChargeItemController {

    private final BusinessChargeItemService businessChargeItemService;

    /**
     * 新增ChargeItem
     * @param businessChargeItem 业务费用项新
     * @return BaseOutput数据
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
     * @param businessChargeItemQuery 业务费用项信息
     * @return 分页数据信息
     */
    @RequestMapping(value="/listPage", method = {RequestMethod.POST})
    public PageOutput<List<BusinessChargeItem>> listPage(@RequestBody(required = false) BusinessChargeItemQuery businessChargeItemQuery){
        if (Objects.isNull(businessChargeItemQuery)){
            businessChargeItemQuery = new BusinessChargeItemQuery();
        }
        List<BusinessChargeItem> list = businessChargeItemService.listByExample(businessChargeItemQuery);
        //总记录
        Long total = list instanceof Page ? ((Page) list).getTotal() : list.size();
        //总页数
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        //当前页数
        int pageNum = list instanceof Page ? ((Page) list).getPageNum() : 1;
        PageOutput output = PageOutput.success();
        output.setData(list).setPageNum(pageNum).setTotal(total).setPageSize(businessChargeItemQuery.getPage()).setPages(totalPage);
        return output;
    }

    /**
     * 查询收费项数据集
     * @param businessChargeItemQuery 查询条件
     * @return
     */
    @RequestMapping(value="/listByExample", method = {RequestMethod.POST})
    public BaseOutput<List<BusinessChargeItem>> listByExample(@RequestBody(required = false) BusinessChargeItemQuery businessChargeItemQuery){
        if (Objects.isNull(businessChargeItemQuery)){
            businessChargeItemQuery = new BusinessChargeItemQuery();
        }
        return BaseOutput.successData(businessChargeItemService.listByExample(businessChargeItemQuery));
    }

    /**
     * 根据ID查询某收费项信息
     * @param id
     * @return
     */
    @PostMapping(value = "/getById")
    public BaseOutput<BusinessChargeItem> getById(@RequestParam("id") Long id) {
        return BaseOutput.success().setData(businessChargeItemService.get(id));
    }

}