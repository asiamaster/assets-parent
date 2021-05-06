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
import com.dili.assets.mapper.CusCategoryMapper;
import com.dili.assets.sdk.dto.CusCategoryDTO;
import com.dili.assets.service.CusCategoryService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ssssssss.magicapi.provider.MagicAPIService;

import java.util.*;
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
    private MagicAPIService magicAPIService;


    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<CusCategoryDTO>> getTree(@RequestBody(required = false) Map<String, Object> map) {
        return BaseOutput.success().setData(magicAPIService.execute("post", "/api/getCategoryTree", map));
    }

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/get")
    public BaseOutput<CusCategoryDTO> get(@RequestBody Map<String, Object> map) {
        return BaseOutput.success().setData(magicAPIService.execute("post", "/api/getCategoryById", map));
    }

    /**
     * 新增品类
     */
    @RequestMapping(value = "/save")
    public Object save(@RequestBody Map<String, Object> map) {
        if (map.containsKey("id") && map.get("id") != null) {
            return magicAPIService.execute("post", "/api/updateCategory", map);
        }
        return magicAPIService.execute("post", "/api/saveCategory", map);
    }

    /**
     * 删除品类
     */
    @RequestMapping(value = "/batchUpdate")
    public Object batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value, @RequestParam("marketId") Long marketId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("value", value);
        map.put("marketId", marketId);
        return magicAPIService.execute("post", "/api/batchUpdate", map);
    }

    /**
     * 根据市场清空品类
     */
    @RequestMapping(value = "/getByKeycode")
    public BaseOutput<CusCategory> getByKeycode(@RequestBody(required = false) Map<String, Object> map) {
        return BaseOutput.success().setData(magicAPIService.execute("post", "/api/getByKeycode", map));
    }

    /**
     * del
     *
     * @param marketId
     * @return
     */
    @RequestMapping(value = "/delByMarket")
    public BaseOutput delByMarket(@RequestBody Long marketId) {
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
        List<Category> categories = null;
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