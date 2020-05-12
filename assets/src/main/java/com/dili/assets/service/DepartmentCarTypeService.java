package com.dili.assets.service;

import java.util.List;

import com.dili.assets.domain.DepartmentCarType;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:33:30.
 */
public interface DepartmentCarTypeService extends BaseService<DepartmentCarType, Long> {

	void deleteByDepartmentId(Long id);

	List<DepartmentCarType> list(Long departmentId);
}