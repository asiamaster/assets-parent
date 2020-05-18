package com.dili.assets.mapper;

import com.dili.assets.domain.CarType;
import com.dili.ss.base.MyMapper;

public interface CarTypeMapper extends MyMapper<CarType> {

	void insertCarType(CarType carType);
}