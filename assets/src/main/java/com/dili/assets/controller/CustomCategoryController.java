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
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        // 根据市场查询自定义品类
        CustomCategory customCategory = new CustomCategory();
        customCategory.setMarketId(input.getMarketId());
        List<CustomCategory> customCategories = customCategoryService.listByExample(customCategory);
        // 根据条件查询基础品类
        input.setState(EnabledStateEnum.ENABLED.getCode()); // 只查询基础品类中启用的数据
        if (StrUtil.isNotBlank(input.getKeyword())) {
            // 如果市场没设置任何品类，则只需要过滤基础数据
            if (CollUtil.isEmpty(customCategories)) {
                input.setLikeName(input.getKeyword());
            }
            input.setOrName(input.getKeyword());
            input.setKeyword(null);
        }
        List<Category> list = categoryMapper.listCategory(input);
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
                    if (state == null || !state.equals(EnabledStateEnum.DISABLED.getCode())) {
                        result.add(category);
                    }
                }
            });
            return BaseOutput.success().setData(StrUtil.isNotBlank(input.getOrName()) ? searchCusName(result, input.getOrName()) : result);
        }
        // 如果没有市场自定义数据，且查询禁用则返回空
        if (state != null && state.equals(EnabledStateEnum.DISABLED.getCode())) {
            return BaseOutput.success().setData(new ArrayList<>());
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
                CustomCategory categoryUpdate = customCategoryService.get(input.getId());
                categoryUpdate.setCusName(input.getCusName());
                categoryUpdate.setKeycode(input.getKeycode());
                customCategoryService.update(categoryUpdate);
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

    /**
     * 过滤品类别名（代码过滤）
     */
    private List<CategoryDTO> searchCusName(List<CategoryDTO> original, String keyword) {
        List<CategoryDTO> result = new ArrayList<>();

        if (CollUtil.isNotEmpty(original)) {
            original.forEach(categoryDTO -> {
                boolean find = false;
                if (categoryDTO.getName().contains(keyword)) {
                    find = true;
                }
                if (StrUtil.isNotBlank(categoryDTO.getCusName()) && categoryDTO.getCusName().contains(keyword)) {
                    find = true;
                }

                if (StrUtil.isNotBlank(categoryDTO.getKeycode()) && categoryDTO.getKeycode().contains(keyword)) {
                    find = true;
                }

                if (find) {
                    result.add(categoryDTO);
                }
            });
        }
        return result;
    }
}