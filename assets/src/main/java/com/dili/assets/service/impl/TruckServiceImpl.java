package com.dili.assets.service.impl;

import com.dili.assets.domain.Truck;
import com.dili.assets.mapper.TruckMapper;
import com.dili.assets.service.TruckService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:33:52.
 */
@Service
public class TruckServiceImpl extends BaseServiceImpl<Truck, Long> implements TruckService {

    public TruckMapper getActualDao() {
        return (TruckMapper)getDao();
    }
}