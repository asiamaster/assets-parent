package com.dili.assets.service.impl;

import com.dili.assets.domain.City;
import com.dili.assets.mapper.CityMapper;
import com.dili.assets.service.CityService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-21 15:27:39.
 */
@Service
public class CityServiceImpl extends BaseServiceImpl<City, Long> implements CityService {

    public CityMapper getActualDao() {
        return (CityMapper)getDao();
    }
}