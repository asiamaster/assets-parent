package com.dili.assets.service;

import com.dili.assets.domain.Category;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
public interface CategoryService extends BaseService<Category, Long> {
    /**
     * 新增品类
     *
     * @param input {@link Category}
     */
    void saveCategory(Category input);

    /**
     * 修改品类
     *
     * @param input {@link Category}
     */
    void updateCategory(Category input);

    /**
     * 批量修改品类状态
     *
     * @param id 主键
     */
    void batchUpdate(Long id, Integer value);
}