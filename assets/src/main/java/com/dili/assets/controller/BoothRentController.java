package com.dili.assets.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.dili.assets.domain.Assets;
import com.dili.assets.domain.BoothRent;
import com.dili.assets.glossary.RentEnum;
import com.dili.assets.service.AssetsService;
import com.dili.assets.service.BoothRentService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-03-03 14:37:36.
 */
@RestController
@RequestMapping("/api/boothRent")
public class BoothRentController {
    @Autowired
    BoothRentService boothRentService;

    @Autowired
    AssetsService assetsService;

    /**
     * 新增摊位租赁时间接口
     */
    @RequestMapping("add")
    public BaseOutput add(@RequestBody BoothRent input) {
        try {
            boothRentService.add(input);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseOutput.failure("系统错误");
        }
        return BaseOutput.success();
    }

    /**
     * 修改成出粗状态
     */
    @RequestMapping("rent")
    public BaseOutput update(@RequestBody BoothRent input) {
        try {
            BoothRent boothRent = new BoothRent();
            boothRent.setFreeze(RentEnum.rent.getCode());
            boothRentService.updateSelectiveByExample(boothRent, input);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            return BaseOutput.failure("系统错误");
        }
        return BaseOutput.success();
    }

    /**
     * 删除租赁
     */
    @RequestMapping("delete")
    public BaseOutput delete(@RequestBody BoothRent input) {
        boothRentService.deleteByExample(input);
        return BaseOutput.success();
    }

    /**
     * 删除租赁
     */
    @RequestMapping("updateEnd")
    public BaseOutput updateEnd(@RequestBody BoothRent input) {
        try {
            BoothRent boothRent = new BoothRent();
            boothRent.setEnd(input.getEnd());
            input.setEnd(null);
            boothRentService.updateSelectiveByExample(boothRent, input);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            return BaseOutput.failure("系统错误");
        }
        return BaseOutput.success();
    }

    /**
     * 删除租赁
     */
    @RequestMapping("getBalance")
    public BaseOutput<Long> getBalance(@RequestBody BoothRent input) {
        try {
            BoothRent query = new BoothRent();
            query.setBoothId(input.getBoothId());
            query.setType(input.getType());

            Assets assets = assetsService.get(input.getBoothId());
            if (assets == null) {
                return BaseOutput.failure("资产不存在");
            }
            List<BoothRent> boothRents = boothRentService.listByExample(query);
            if (CollUtil.isEmpty(boothRents)) {
                return BaseOutput.success().setData(assets.getNumber());
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
                    return BaseOutput.success().setData(assets.getNumber());
                } else {
                    return BaseOutput.success().setData(min);
                }

            }
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            return BaseOutput.failure("系统错误");
        }
    }

}