package com.dili.assets.service.impl;

import com.dili.assets.domain.District;
import com.dili.assets.mapper.DistrictMapper;
import com.dili.assets.service.DistrictService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@Service
public class DistrictServiceImpl extends BaseServiceImpl<District, Long> implements DistrictService {

    public DistrictMapper getActualDao() {
        return (DistrictMapper)getDao();
    }
}