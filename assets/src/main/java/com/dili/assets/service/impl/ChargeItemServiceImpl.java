package com.dili.assets.service.impl;

import com.dili.assets.domain.ChargeItem;
import com.dili.assets.mapper.ChargeItemMapper;
import com.dili.assets.service.ChargeItemService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-26 18:24:30.
 */
@Service
public class ChargeItemServiceImpl extends BaseServiceImpl<ChargeItem, Long> implements ChargeItemService {

    public ChargeItemMapper getActualMapper() {
        return (ChargeItemMapper)getDao();
    }
}