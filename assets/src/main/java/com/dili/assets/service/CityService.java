package com.dili.assets.service;

import com.dili.assets.domain.City;
import com.dili.assets.sdk.dto.CityKeyWordsQueryDto;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-21 15:27:39.
 */
public interface CityService extends BaseService<City, Long> {

    /**
     * 城市查询接口
     * 简拼，全拼，汉字简称，汉字全称，地址级别，查询地址数据
     *
     * @param city
     * @return
     */
    List<City> listByKeywords(CityKeyWordsQueryDto city);
}