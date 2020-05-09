package com.dili.assets.service.impl;

import com.dili.assets.domain.CtypeToBtype;
import com.dili.assets.mapper.CtypeToBtypeMapper;
import com.dili.assets.service.CtypeToBtypeService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-09 17:43:57.
 */
@Service
public class CtypeToBtypeServiceImpl extends BaseServiceImpl<CtypeToBtype, Long> implements CtypeToBtypeService {

    public CtypeToBtypeMapper getActualDao() {
        return (CtypeToBtypeMapper)getDao();
    }
}