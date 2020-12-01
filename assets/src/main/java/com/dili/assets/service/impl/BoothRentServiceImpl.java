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

    private

    @Autowired
    RedisDistributedLock redisDistributedLock;

    @Override
    @Transactional
    public void add(BoothRent input) {
        if (redisDistributedLock.tryGetLock(key, key, 180L)) {
            try {
                BoothRent query = new BoothRent();
                query.setBoothId(input.getBoothId());
                query.setType(input.getType());
                List<BoothRent> boothRents = this.listByExample(query);
                input.setFreeze(RentEnum.freeze.getCode());
                if (CollUtil.isEmpty(boothRents)) {
                    saveOrUpdate(input);
                } else {
                    boolean canSave = true;
                    Double min = 99999D;
                    for (BoothRent boothRent : boothRents) {
                        // 判断开始时间

                        if (DateUtil.isIn(boothRent.getStart(), input.getStart(), input.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null && boothRent.getNumber() < min) {
                                min = boothRent.getNumber();
                            }
                            break;
                        }
                        // 判断结束时间

                        if (DateUtil.isIn(boothRent.getStart(), input.getStart(), input.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null && boothRent.getNumber() < min) {
                                min = boothRent.getNumber();
                            }
                            break;
                        }

                        if (DateUtil.isIn(input.getStart(), boothRent.getStart(), boothRent.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null && boothRent.getNumber() < min) {
                                min = boothRent.getNumber();
                            }
                            break;
                        }
                        // 判断结束时间

                        if (DateUtil.isIn(input.getEnd(), boothRent.getStart(), boothRent.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null && boothRent.getNumber() < min) {
                                min = boothRent.getNumber();
                            }
                            break;
                        }
                    }

                    if (canSave) {
                        saveOrUpdate(input);
                    } else {
                        if (input.getType() == 2) {
                            if (input.getNumber() > min) {
                                throw new BusinessException("2500", "此时间段已有租赁");
                            } else {
                                saveOrUpdate(input);
                            }
                        } else {
                            throw new BusinessException("2500", "此时间段已有租赁");
                        }
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