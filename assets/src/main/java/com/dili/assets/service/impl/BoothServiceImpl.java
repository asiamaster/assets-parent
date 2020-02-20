package com.dili.assets.service.impl;

import com.dili.assets.domain.Booth;
import com.dili.assets.mapper.BoothMapper;
import com.dili.assets.service.BoothService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@Service
public class BoothServiceImpl extends BaseServiceImpl<Booth, Long> implements BoothService {

    public BoothMapper getActualDao() {
        return (BoothMapper) getDao();
    }

    @Override
    public void saveBooth(Booth booth) {
        this.saveOrUpdate(booth);
    }

    @Override
    public String listForPage(Booth input) {
        try {
            return this.listEasyuiPageByExample(input, true).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}