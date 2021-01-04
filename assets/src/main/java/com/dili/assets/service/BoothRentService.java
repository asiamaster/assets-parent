package com.dili.assets.service;

import com.dili.assets.domain.BoothRent;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-03-03 14:37:36.
 */
public interface BoothRentService extends BaseService<BoothRent, Long> {

    /**
     * 新增摊位租赁时间
     */
    void add(BoothRent input);

    List<BoothRent> selectUsed();

    List<BoothRent> selectUnUsed();
}