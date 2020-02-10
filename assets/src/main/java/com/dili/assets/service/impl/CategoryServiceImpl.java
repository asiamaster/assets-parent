package com.dili.assets.service.impl;

import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.domain.Category;
import com.dili.assets.service.CategoryService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {

    public CategoryMapper getActualDao() {
        return (CategoryMapper)getDao();
    }
}