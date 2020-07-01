package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.CustomCategory;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.mapper.CustomCategoryMapper;
import com.dili.assets.service.CategoryService;
import com.dili.assets.service.CustomCategoryService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 15:42:05.
 */
@Service
public class CustomCategoryServiceImpl extends BaseServiceImpl<CustomCategory, Long> implements CustomCategoryService {

    public CustomCategoryMapper getActualDao() {
        return (CustomCategoryMapper) getDao();
    }

    @Autowired
    private CategoryService categoryService;

    @Override
    public void batchUpdate(Long id, Integer value, Long marketId) {
        // 从基本品类查询所有品类，包含子品类如果有
        Category parent = categoryService.get(id);
        List<Long> child_ids = new ArrayList<>();
        CategoryQuery condition = new CategoryQuery();
        condition.setQueryPath(parent.getPath());
        condition.setState(1);
        List<Category> byExample = categoryService.listByExample(condition);
        if (CollUtil.isNotEmpty(byExample)) {
            byExample.forEach(category -> child_ids.add(category.getId()));
        } else {
            child_ids.add(id);
        }
        List<CustomCategory> batchInsertList = new ArrayList<>();
        List<Long> batchUpdatetList = new ArrayList<>();
        // 构建条件
        CustomCategory cc_condition = new CustomCategory();
        cc_condition.setMarketId(marketId);
        List<CustomCategory> list = this.listByExample(cc_condition);
        for (Long child_id : child_ids) {
            // 处理当前更改的品类状态，如果自定义品类库没有则新增，否则直接改状态
            if (CollUtil.isNotEmpty(list)) {
                for (CustomCategory c_category : list) {
                    if (c_category.getCategory().equals(child_id)) {
                        batchUpdatetList.add(c_category.getId());
                    }
                }
            } else {
                CustomCategory c_category = new CustomCategory();
                c_category.setState(value);
                c_category.setCategory(child_id);
                c_category.setMarketId(marketId);
                batchInsertList.add(c_category);
            }
        }
        // 批量新增的数据
        if (CollUtil.isNotEmpty(batchInsertList)) {
            this.batchInsert(batchInsertList);
        }
        // 批量修改的数据
        if (CollUtil.isNotEmpty(batchUpdatetList)) {
            this.getActualDao().batchUpdateCustomCategory(value, batchUpdatetList);
        }

    }
}