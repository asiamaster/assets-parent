package com.dili.assets.service.impl;

import com.dili.assets.domain.DepartmentCarType;
import com.dili.assets.mapper.DepartmentCarTypeMapper;
import com.dili.assets.service.DepartmentCarTypeService;
import com.dili.ss.base.BaseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:33:30.
 */
@Service
public class DepartmentCarTypeServiceImpl extends BaseServiceImpl<DepartmentCarType, Long> implements DepartmentCarTypeService {

    public DepartmentCarTypeMapper getActualDao() {
        return (DepartmentCarTypeMapper)getDao();
    }

	@Override
	public void deleteByDepartmentId(Long id) {
		DepartmentCarType departmentCarType = new DepartmentCarType();
		departmentCarType.setDepartmentId(id);
		getActualDao().deleteByDepartmentId(departmentCarType);
	}

	@Override
	public List<DepartmentCarType> list(Long departmentId) {
		DepartmentCarType departmentCarType = new DepartmentCarType();
		departmentCarType.setDepartmentId(departmentId);
		return getActualDao().list(departmentCarType);
	}
}