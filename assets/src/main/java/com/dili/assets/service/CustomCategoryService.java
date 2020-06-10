package com.dili.assets.service;

import com.dili.assets.domain.CustomCategory;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 15:42:05.
 */
public interface CustomCategoryService extends BaseService<CustomCategory, Long> {

    /**
     * 批量修改品类状态
     *
     * @param id 主键
     */
    void batchUpdate(Long id, Integer value, Long marketId);
}