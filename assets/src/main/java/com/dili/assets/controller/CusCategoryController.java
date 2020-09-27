package com.dili.assets.controller;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.CusCategory;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.mapper.CusCategoryMapper;
import com.dili.assets.sdk.dto.CategoryDTO;
import com.dili.assets.sdk.dto.CusCategoryDTO;
import com.dili.assets.sdk.dto.CusCategoryQuery;
import com.dili.assets.service.CategoryService;
import com.dili.assets.service.CusCategoryService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@RestController
@RequestMapping("/api/cusCategory")
public class CusCategoryController {
    @Autowired
    CusCategoryService cusCategoryService;

    @Autowired
    CusCategoryMapper cusCategoryMapper;

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<CusCategory>> getTree(@RequestBody(required = false) CusCategoryQuery input) {
        if (input == null || input.getMarketId() == null) {
            return BaseOutput.failure("市场ID不能为空");
        }
        List<CusCategory> list = cusCategoryMapper.listCategory(input);
        return BaseOutput.success().setData(list);
    }

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/get")
    public BaseOutput<Category> get(@RequestBody Long id) {
        CusCategory category = cusCategoryService.get(id);
        return BaseOutput.success().setData(category);
    }

    /**
     * 新增品类
     */
    @RequestMapping(value = "/save")
    public BaseOutput save(@RequestBody CusCategory input) {
        try {
            if (input.getId() != null) {
                cusCategoryService.updateCategory(input);
            } else {
                cusCategoryService.saveCategory(input);
            }
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getMessage());
        } catch (Exception e) {
            return BaseOutput.failure("保存失败");
        }
        return BaseOutput.success().setData(cusCategoryService.get(input.getId()));
    }

    /**
     * 删除品类
     */
    @RequestMapping(value = "/batchUpdate")
    public BaseOutput batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value) {
        cusCategoryService.batchUpdate(id, value);
        return BaseOutput.success();
    }

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getByKeycode")
    public BaseOutput<CusCategory> getByKeycode(@RequestBody(required = false) CusCategoryQuery input) {
        if (input == null || input.getMarketId() == null) {
            return BaseOutput.failure("未知市场或参数");
        }
        // 查询自定义品类
        List<CusCategory> cusList = cusCategoryMapper.listCategory(input);
        if (CollUtil.isNotEmpty(cusList)) {
            return BaseOutput.success().setData(cusList.get(0));
        } else {
            return BaseOutput.success();
        }
    }
}