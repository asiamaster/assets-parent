package com.dili.assets.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.sdk.dto.CategoryDTO;
import com.dili.assets.service.CategoryService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import com.dili.uap.sdk.session.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<Category>> getTree(@RequestBody(required = false) CategoryQuery input) {
        List<Category> list = categoryMapper.listCategory(input);
        return BaseOutput.success().setData(list);
    }

    /**
     * test
     * @return
     */
    @PostMapping(value = "/test")
    public BaseOutput test(Long parentId ,Integer sheetindex) {
//        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("/Users/shaofan/Downloads/c.xlsx"),sheetindex);
//        List<Map<String,Object>> readAll = reader.readAll();
//        Set<String> erji = new HashSet<>();
//        readAll.forEach(obj -> erji.add(obj.get(obj.keySet().stream().findFirst().get()).toString()));
//        System.out.println(erji);
//        Map<String, Category> categoryDTOMap = new HashMap<>();
//        for (int i = erji.stream().toArray().length - 1; i >= 0; i--) {
//            String o =erji.stream().toArray()[i].toString();
//            Category categoryDTO = new Category();
//            categoryDTO.setParent(parentId);
//            categoryDTO.setName(o);
//            categoryDTO.setPingying(PinyinUtil.converterToSpell(o));
//            categoryDTO.setPyInitials(PinyinUtil.converterToFirstSpell(o));
//            categoryDTO.setCreateTime(new Date());
//            categoryDTO.setCreatorId(0L);
//            categoryDTO.setModifyTime(new Date());
//            categoryService.saveCategory(categoryDTO);
//            categoryDTOMap.put(o,categoryDTO);
//        }
//
//        readAll.forEach(obj -> {
//            Object[] objects = obj.keySet().stream().toArray();
//            String name = obj.get(objects[1].toString()).toString();
//            String code = obj.get(objects[2].toString()).toString();
//            Category parent = categoryDTOMap.get(obj.get(objects[0].toString()));
//            System.out.println("parent:" + parent.getId() + ";name:" + name + ";code:" + code);
//
//            Category categoryDTO = new Category();
//            categoryDTO.setParent(parent.getId());
//            categoryDTO.setName(name);
//            categoryDTO.setCode(code);
//            categoryDTO.setPingying(PinyinUtil.converterToSpell(name));
//            categoryDTO.setPyInitials(PinyinUtil.converterToFirstSpell(name));
//            categoryDTO.setCreateTime(new Date());
//            categoryDTO.setCreatorId(0L);
//            categoryDTO.setModifyTime(new Date());
//            categoryService.saveCategory(categoryDTO);
//        });

        return BaseOutput.success();
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
            return BaseOutput.failure(e.getMessage());
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