package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.dili.assets.domain.BoothRent;
import com.dili.assets.glossary.RentEnum;
import com.dili.assets.mapper.BoothRentMapper;
import com.dili.assets.service.BoothRentService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.redis.service.RedisDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-03-03 14:37:36.
 */
@Service
public class BoothRentServiceImpl extends BaseServiceImpl<BoothRent, Long> implements BoothRentService {

    private final String key = "booth_rent";

    public BoothRentMapper getActualDao() {
        return (BoothRentMapper) getDao();
    }

    @Autowired
    RedisDistributedLock redisDistributedLock;

    @Override
    @Transactional
    public void add(BoothRent input) {
        if (redisDistributedLock.tryGetLock(key, key, 180L)) {
            try {
                BoothRent query = new BoothRent();
                query.setBoothId(input.getBoothId());
                List<BoothRent> boothRents = this.listByExample(query);
                input.setFreeze(RentEnum.freeze.getCode());
                if (CollUtil.isEmpty(boothRents)) {
                    saveOrUpdate(input);
                } else {
                    boolean canSave = true;
                    for (BoothRent boothRent : boothRents) {
                        // 判断开始时间
                        // 1,如果传入的开始时间在当前开始时间之后，并且开始时间在当前结束时间之前
                        if (DateUtil.compare(input.getStart(), boothRent.getStart()) > 0 && DateUtil.compare(input.getStart(), boothRent.getEnd()) < 0) {
                            canSave = false;
                            break;
                        }
                        // 判断结束时间
                        // 1,如果传入的结束时间在当前开始时间之后，并且结束时间在当前结束时间之前
                        if (DateUtil.compare(input.getEnd(), boothRent.getStart()) > 0 && DateUtil.compare(input.getEnd(), boothRent.getEnd()) < 0) {
                            canSave = false;
                            break;
                        }
                    }
                    if (canSave) {
                        saveOrUpdate(input);
                    } else {
                        throw new BusinessException("2500", "此时间段已有租赁");
                    }
                }
            } finally {
                //完成后释放锁
                if (redisDistributedLock.exists(key)) {
                    redisDistributedLock.releaseLock(key, key);
                }
            }

        } else {
            throw new BusinessException("5000", "系统错误");
        }
    }
}