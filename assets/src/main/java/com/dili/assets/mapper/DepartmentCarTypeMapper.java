package com.dili.assets.mapper;

import java.util.List;

import com.dili.assets.domain.DepartmentCarType;
import com.dili.ss.base.MyMapper;

public interface DepartmentCarTypeMapper extends MyMapper<DepartmentCarType> {
	
	void deleteByDepartmentId(DepartmentCarType departmentCarType);

	List<DepartmentCarType> list(DepartmentCarType departmentCarType);
}