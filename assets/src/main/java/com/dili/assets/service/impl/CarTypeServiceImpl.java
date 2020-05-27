package com.dili.assets.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dili.assets.domain.CarType;
import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.mapper.CarTypeMapper;
import com.dili.assets.service.CarTypeService;
import com.dili.ss.base.BaseServiceImpl;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-09 16:44:34.
 */
@Service
public class CarTypeServiceImpl extends BaseServiceImpl<CarType, Long> implements CarTypeService {

    public CarTypeMapper getActualDao() {
        return (CarTypeMapper)getDao();
    }

	@Override
	public void insertCarType(CarType carType) {
		getActualDao().insertCarType(carType);
	}

	@Override
	public List<CarType> listCarType(CarTypePublic carType) {
		return getActualDao().listCarType(carType);
	}
}