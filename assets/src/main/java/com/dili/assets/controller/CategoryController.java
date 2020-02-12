package com.dili.assets.controller;

import com.dili.assets.domain.Category;
import com.dili.assets.service.CategoryService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<Category>> getTree(@RequestBody(required = false) Category input) {
        if (input == null) {
            input = new Category();
        }
        // 过滤删除的品类
        input.setStateFilter(3);
        List<Category> list = categoryService.listByExample(input);
        return BaseOutput.success().setData(list);
    }

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/get")
    public BaseOutput<Category> get(@RequestBody Long id) {
        Category category = categoryService.get(id);
        return BaseOutput.success().setData(category);
    }

    /**
     * 新增品类
     */
    @RequestMapping(value = "/save")
    public BaseOutput save(@RequestBody Category input) {
        try {
            if (input.getId() != null) {
                categoryService.updateCategory(input);
            } else {
                categoryService.saveCategory(input);
            }
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure("保存失败");
        }
        return BaseOutput.success().setData(categoryService.get(input.getId()));
    }

    /**
     * 删除品类
     */
    @RequestMapping(value = "/batchUpdate")
    public BaseOutput batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value) {
        categoryService.batchUpdate(id, value);
        return BaseOutput.success();
    }
}