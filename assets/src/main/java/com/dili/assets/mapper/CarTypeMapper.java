package com.dili.assets.mapper;

import java.util.List;

import com.dili.assets.domain.CarType;
import com.dili.assets.domain.CarTypePublic;
import com.dili.ss.base.MyMapper;

public interface CarTypeMapper extends MyMapper<CarType> {

	void insertCarType(CarType carType);

	List<CarType> listCarType(CarTypePublic carType);
	
	List<CarType> checkRepeat(CarType carType);
}