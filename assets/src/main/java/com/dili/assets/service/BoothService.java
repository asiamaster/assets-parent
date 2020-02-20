package com.dili.assets.service;

import com.dili.assets.domain.Booth;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
public interface BoothService extends BaseService<Booth, Long> {
    /**
     * 新增摊位
     */
    void saveBooth(Booth booth);

    /**
     * 获取摊位列表
     */
    String listForPage(Booth booth);
}