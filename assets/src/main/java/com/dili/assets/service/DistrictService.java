package com.dili.assets.service;

import com.dili.assets.domain.District;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
public interface DistrictService extends BaseService<District, Long> {

    /**
     * 添加区域
     */
    void saveDistrict(District input);

    /**
     * 需改区域
     */
    void editDistrict(District input);

    /**
     * 拆分区域
     */
    void division(Long parentId, String[] names, String[] notes, String[] numbers);

    /**
     * 删除区域
     */
    void delDistrict(Long id);

    /**
     * 批量更新
     */
    void childrenUpdateByPid(District update);

    /**
     * 查询区域商户
     */
    List<District> selectByAreaMarket(Long id);
}