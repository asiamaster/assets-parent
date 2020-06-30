package com.dili.assets.service;

import com.dili.assets.domain.Assets;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.sdk.dto.AssetsDTO;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
public interface AssetsService extends BaseService<Assets, Long> {
    /**
     * 新增摊位
     */
    void saveBooth(Assets booth);

    /**
     * 获取摊位列表
     */
    String listForPage(BoothQuery booth);

    /**
     * 删除摊位
     */
    void deleteBooth(Long id);

    /**
     * 拆分摊位
     */
    void boothSplit(Long parentId, String[] names, String notes, String[] numbers);

    /**
     * 搜索摊位
     */
    List<AssetsDTO> search(BoothQuery query);

    /**
     * 获取摊位剩余面积
     */
    Double getBoothBalance(Long id);
}