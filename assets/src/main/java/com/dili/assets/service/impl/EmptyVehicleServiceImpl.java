package com.dili.assets.service.impl;

import com.dili.assets.domain.EmptyVehicle;
import com.dili.assets.mapper.EmptyVehicleMapper;
import com.dili.assets.service.EmptyVehicleService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:34:12.
 */
@Service
public class EmptyVehicleServiceImpl extends BaseServiceImpl<EmptyVehicle, Long> implements EmptyVehicleService {

    public EmptyVehicleMapper getActualDao() {
        return (EmptyVehicleMapper)getDao();
    }
}