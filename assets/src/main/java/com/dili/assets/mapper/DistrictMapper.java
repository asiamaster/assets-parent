package com.dili.assets.mapper;

import com.dili.assets.domain.District;
import com.dili.ss.base.MyMapper;

import java.util.List;

public interface DistrictMapper extends MyMapper<District> {
    /**
     * 批量更新
     */
    void childrenUpdateByPid(District update);

    List<District> selectByAreaMarket(Long id);
}