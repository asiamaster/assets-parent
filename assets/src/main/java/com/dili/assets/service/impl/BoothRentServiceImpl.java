package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.dili.assets.domain.Assets;
import com.dili.assets.domain.BoothRent;
import com.dili.assets.glossary.RentEnum;
import com.dili.assets.mapper.BoothRentMapper;
import com.dili.assets.service.AssetsService;
import com.dili.assets.service.BoothRentService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.redis.service.RedisDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private AssetsService assetsService;

    private

    @Autowired
    RedisDistributedLock redisDistributedLock;

    @Override
    @Transactional
    public void add(BoothRent input) {
        if (redisDistributedLock.tryGetLock(key, key, 180L)) {
            try {
                // 查询摊位信息
                Assets assets = assetsService.get(input.getAssetsId());
                if (input.getType() == 2) {
                    if (input.getNumber() > assets.getNumber()) {
                        throw new BusinessException("2501", "数量不足");
                    }
                }
                // 查询租赁时间段信息
                BoothRent query = new BoothRent();
                query.setAssetsId(input.getAssetsId());
                List<BoothRent> boothRents = this.listByExample(query);
                List<BoothRent> temp = new ArrayList<>();
                // 如果没有租赁信息则直接保存
                if (CollUtil.isEmpty(boothRents)) {
                    save(input);
                } else {
                    // 是否能保存
                    boolean canSave = true;
                    // 取交叉时间段最大值
                    Double max = 0D;
                    for (BoothRent boothRent : boothRents) {
                        // 判断开始时间

                        if (DateUtil.isIn(boothRent.getStart(), input.getStart(), input.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null) {
                                temp.add(boothRent);
                                max += boothRent.getNumber();
                            }
                            continue;
                        }
                        // 判断结束时间

                        if (DateUtil.isIn(boothRent.getEnd(), input.getStart(), input.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null) {
                                temp.add(boothRent);
                                max += boothRent.getNumber();
                            }
                            continue;
                        }

                        if (DateUtil.isIn(input.getStart(), boothRent.getStart(), boothRent.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null) {
                                temp.add(boothRent);
                                max += boothRent.getNumber();
                            }
                            continue;
                        }
                        // 判断结束时间

                        if (DateUtil.isIn(input.getEnd(), boothRent.getStart(), boothRent.getEnd())) {
                            canSave = false;
                            if (boothRent.getNumber() != null) {
                                temp.add(boothRent);
                                max += boothRent.getNumber();
                            }
                        }
                    }

                    // 如果是冷库则求租赁最大值
                    if (input.getType() == 2) {
                        for (BoothRent boothRent : temp) {
                            if (boothRent.getNumber() != null && boothRent.getNumber() > max) {
                                max = boothRent.getNumber();
                            }
                        }
                    }

                    if (canSave) {
                        save(input);
                    } else {
                        if (input.getType() == 2) {
                            if (input.getNumber() > (assets.getNumber() - max)) {
                                throw new BusinessException("2501", "数量不足");
                            } else {
                                save(input);
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

    @Override
    public List<BoothRent> selectUsed() {
        return getActualDao().selectUsed();
    }

    @Override
    public List<BoothRent> selectUnUsed() {
        return getActualDao().selectUnUsed();
    }

    private void save(BoothRent input) {
        // 初始化为冻结状态
        input.setFreeze(RentEnum.freeze.getCode());
        saveOrUpdate(input);
    }
}