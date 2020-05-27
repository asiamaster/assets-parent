package com.dili.assets.service.impl;

import com.dili.assets.domain.BankUnionInfo;
import com.dili.assets.mapper.BankUnionInfoMapper;
import com.dili.assets.service.BankUnionInfoService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-25 16:11:17.
 */
@Service
public class BankUnionInfoServiceImpl extends BaseServiceImpl<BankUnionInfo, Long> implements BankUnionInfoService {

    public BankUnionInfoMapper getActualDao() {
        return (BankUnionInfoMapper)getDao();
    }
}