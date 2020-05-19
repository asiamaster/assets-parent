package com.dili.assets.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.CustomCategory;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.mapper.CustomCategoryMapper;
import com.dili.assets.sdk.dto.CategoryDTO;
import com.dili.assets.service.CustomCategoryService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 15:42:05.
 */
@RestController
@RequestMapping("/api/customCategory")
public class CustomCategoryController {
    @Autowired
    CustomCategoryService customCategoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CustomCategoryMapper customCategoryMapper;

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<CategoryDTO>> getTree(@RequestBody(required = false) CategoryQuery input) {
        if (input == null || input.getMarketId() == null) {
            return BaseOutput.failure("未知市场或参数");
        }
        Integer state = input.getState();
        // 根据条件查询基础品类
        input.setState(1); // 只查询基础品类中启用的数据
        List<Category> list = categoryMapper.listCategory(input);
        // 根据市场查询自定义品类
        CustomCategory customCategory = new CustomCategory();
        customCategory.setMarketId(input.getMarketId());
        List<CustomCategory> customCategories = customCategoryService.listByExample(customCategory);
        // 如果没有市场自定义品类则返回所有基础品类
        if (CollUtil.isNotEmpty(customCategories)) {
            List<CategoryDTO> result = new ArrayList<>();
            list.forEach(obj -> {
                Optional<CustomCategory> first = customCategories.stream().filter(customCategory1 -> customCategory1.getCategory().equals(obj.getId())).findFirst();
                if (first.isPresent()) {
                    CustomCategory custom = first.get();
                    CategoryDTO category = new CategoryDTO();
                    BeanUtil.copyProperties(obj, category);
                    category.setCusName(custom.getCusName());
                    category.setKeycode(custom.getKeycode());
                    category.setState(custom.getState());
                    if (state == null || state.equals(category.getState())) {
                        result.add(category);
                    }
                } else {
                    CategoryDTO category = new CategoryDTO();
                    BeanUtil.copyProperties(obj, category);
                    // 如果是查询禁用的自定义品类则不展示基础品类数据
                    if (state == null || state != 2) {
                        result.add(category);
                    }
                }
            });
            return BaseOutput.success().setData(result);
        }
        return BaseOutput.success().setData(list);
    }

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/get")
    public BaseOutput<Category> get(Long id, Long marketId) {
        CustomCategory category = new CustomCategory();
        category.setCategory(id);
        category.setMarketId(marketId);
        List<CustomCategory> customCategories = customCategoryService.listByExample(category);
        if (CollUtil.isNotEmpty(customCategories)) {
            return BaseOutput.success().setData(customCategories.get(0));
        }
        return BaseOutput.success();
    }

    /**
     * 新增品类
     */
    @RequestMapping(value = "/save")
    public BaseOutput save(@RequestBody CustomCategory input) {
        try {
            if (input.getId() != null) {
                customCategoryMapper.updateByPrimaryKeySelective(input);
            } else {
                input.setState(1);
                customCategoryMapper.insert(input);
            }
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure("保存失败");
        }
        return BaseOutput.success();
    }

    /**
     * 删除品类
     */
    @RequestMapping(value = "/batchUpdate")
    public BaseOutput batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value, @RequestParam("marketId") Long marketId) {
        try {
            customCategoryService.batchUpdate(id, value, marketId);
        } catch (Exception e) {
            return BaseOutput.failure("操作失败");
        }
        return BaseOutput.success();
    }
}