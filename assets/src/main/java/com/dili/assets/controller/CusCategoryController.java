package com.dili.assets.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.dili.assets.common.PinyinUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.CategoryNew;
import com.dili.assets.domain.CusCategory;
import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.mapper.CusCategoryMapper;
import com.dili.assets.sdk.dto.CusCategoryQuery;
import com.dili.assets.service.CusCategoryService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private CategoryMapper categoryMapper;

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
        return BaseOutput.success().setData(input.getId());
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
     * 根据市场清空品类
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

    /**
     * del
     * @param marketId
     * @return
     */
    @RequestMapping(value = "/delByMarket")
    public BaseOutput delByMarket(@RequestBody Long marketId){
        CusCategory example = new CusCategory();
        example.setMarketId(marketId);
        cusCategoryService.deleteByExample(example);
        return BaseOutput.success();
    }

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/test")
    public BaseOutput test() {
        List<CusCategory> list = this.cusCategoryService.list(null);
        if (CollUtil.isNotEmpty(list)) {
            return BaseOutput.success("已有数据无法导入");
        }
        Long id = 3675L;
        List<Category> categories = categoryMapper.listCategory(null);
        List<CategoryNew> categoryNews = JSON.parseArray(JSON.toJSONString(categories), CategoryNew.class);
        Optional<CategoryNew> first = categoryNews.stream().filter(it -> it.getId().equals(id)).findFirst();

        if (first.isPresent()) {
            CategoryNew categoryNew = first.get();
            find(categoryNews, categoryNew);
            Snowflake snowflake = IdUtil.getSnowflake(1, 1);
            savechildren(0L, categoryNew.getChildren(), snowflake);
        }
        return BaseOutput.success();
    }

    /**
     * test
     *
     * @param parentId
     * @param children
     */
    private void savechildren(Long parentId, List<CategoryNew> children, Snowflake snowflake) {
        if (CollUtil.isNotEmpty(children)) {
            for (CategoryNew categoryNew : children) {
                CusCategory cusCategory = new CusCategory();
                cusCategory.setName(categoryNew.getName());
                if (StrUtil.isBlank(cusCategory.getPingying())) {
                    cusCategory.setPingying(PinyinUtil.converterToSpell(categoryNew.getName()));
                    cusCategory.setPyInitials(PinyinUtil.converterToFirstSpell(categoryNew.getName()));
                } else {
                    cusCategory.setPingying(categoryNew.getPingying());
                    cusCategory.setPyInitials(categoryNew.getPyInitials());
                }
                cusCategory.setIcon(categoryNew.getIcon());
                cusCategory.setParent(parentId);
                cusCategory.setCreatorId(categoryNew.getCreatorId());
                cusCategory.setCreateTime(new Date());
                cusCategory.setModifyTime(new Date());
                if (StrUtil.isBlank(categoryNew.getCode())) {
                    cusCategory.setKeycode(snowflake.nextIdStr());
                } else {
                    cusCategory.setKeycode(categoryNew.getCode());
                }
                cusCategory.setCategoryId(1L);
                cusCategory.setMarketId(17L);
                cusCategoryService.saveCategory(cusCategory);
                savechildren(cusCategory.getId(), categoryNew.getChildren(), snowflake);
            }
        }
    }

    /**
     * te
     *
     * @param list
     * @param categoryNew
     */
    private void find(List<CategoryNew> list, CategoryNew categoryNew) {
        List<CategoryNew> collect = list.stream().filter(it -> it.getParent().equals(categoryNew.getId())).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(collect)) {
            for (CategoryNew aNew : collect) {
                find(list, aNew);
            }
        }
        categoryNew.setChildren(collect);
    }
}