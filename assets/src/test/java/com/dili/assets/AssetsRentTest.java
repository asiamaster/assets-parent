package com.dili.assets;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.dili.assets.domain.Assets;
import com.dili.assets.domain.BoothRent;
import com.dili.ss.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class AssetsRentTest {
    public static void main(String[] args) {
        BoothRent input = new BoothRent();
        input.setStart(DateUtil.parse("2020-12-2 00:00:00"));
        input.setEnd(DateUtil.parse("2020-12-8 23:59:59"));
        input.setNumber(1000D);
        input.setType(2);

        // 查询摊位信息
        Assets assets = new Assets();
        assets.setNumber(3000D);
        if (input.getType() == 2) {
            if (input.getNumber() > assets.getNumber()) {
                throw new BusinessException("2501", "数量不足");
            }
        }
        // 查询租赁时间段信息
        BoothRent query = new BoothRent();
        query.setAssetsId(input.getAssetsId());
        List<BoothRent> boothRents = new ArrayList<>();
        BoothRent boothRent1 = new BoothRent();
        boothRent1.setStart(DateUtil.parse("2020-12-1 00:00:00"));
        boothRent1.setEnd(DateUtil.parse("2020-12-10 23:59:59"));
        boothRent1.setNumber(500D);
        boothRents.add(boothRent1);

        BoothRent boothRent2 = new BoothRent();
        boothRent2.setStart(DateUtil.parse("2020-12-1 00:00:00"));
        boothRent2.setEnd(DateUtil.parse("2020-12-10 23:59:59"));
        boothRent2.setNumber(500D);
        boothRents.add(boothRent2);

        BoothRent boothRent3 = new BoothRent();
        boothRent3.setStart(DateUtil.parse("2020-12-3 00:00:00"));
        boothRent3.setEnd(DateUtil.parse("2020-12-8 23:59:59"));
        boothRent3.setNumber(500D);
        boothRents.add(boothRent3);


        // 如果没有租赁信息则直接保存
        if (CollUtil.isEmpty(boothRents)) {
            System.out.println("没有租赁信息则直接保存");
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
                        max += boothRent.getNumber();
                    }
                    continue;
                }
                // 判断结束时间

                if (DateUtil.isIn(boothRent.getEnd(), input.getStart(), input.getEnd())) {
                    canSave = false;
                    if (boothRent.getNumber() != null) {
                        max += boothRent.getNumber();
                    }
                    continue;
                }

                if (DateUtil.isIn(input.getStart(), boothRent.getStart(), boothRent.getEnd())) {
                    canSave = false;
                    if (boothRent.getNumber() != null) {
                        max += boothRent.getNumber();
                    }
                    continue;
                }
                // 判断结束时间

                if (DateUtil.isIn(input.getEnd(), boothRent.getStart(), boothRent.getEnd())) {
                    canSave = false;
                    if (boothRent.getNumber() != null) {
                        max += boothRent.getNumber();
                    }
                }
            }

            // 如果是冷库则求租赁最大值
            if (input.getType() == 2) {
                for (BoothRent boothRent : boothRents) {
                    if (boothRent.getNumber() != null && boothRent.getNumber() > max) {
                        max = boothRent.getNumber();
                    }
                }
            }

            if (canSave) {
                System.out.println("没有交叉直接保存");
            } else {
                if (input.getType() == 2) {
                    if (input.getNumber() > (assets.getNumber() - max)) {
                        throw new BusinessException("2501", "数量不足:" + (assets.getNumber() - max));
                    } else {
                        System.out.println("保存，数量足够:" + (assets.getNumber() - max));
                    }
                } else {
                    throw new BusinessException("2500", "此时间段已有租赁");
                }
            }
        }
    }
}
