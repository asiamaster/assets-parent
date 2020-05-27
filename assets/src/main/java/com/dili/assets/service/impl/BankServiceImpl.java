package com.dili.assets.service.impl;

import com.dili.assets.domain.Bank;
import com.dili.assets.mapper.BankMapper;
import com.dili.assets.service.BankService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-25 16:10:36.
 */
@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, Long> implements BankService {

    public BankMapper getActualDao() {
        return (BankMapper)getDao();
    }
}