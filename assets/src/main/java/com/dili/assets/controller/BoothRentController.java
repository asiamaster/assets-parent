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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-03-03 14:37:36.
 */
@RestController
@RequestMapping("/api/boothRent")
@Slf4j
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
            log.error("系统错误", e);
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
            log.error("系统错误", e);
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
            log.error("系统错误", e);
            return BaseOutput.failure("系统错误");
        }
        return BaseOutput.success();
    }

    /**
     * 删除租赁
     */
    @RequestMapping("getBalance")
    public BaseOutput<Double> getBalance(@RequestBody BoothRent input) {
        try {
            BoothRent query = new BoothRent();
            query.setAssetsId(input.getAssetsId());

            Assets assets = assetsService.get(input.getAssetsId());
            List<BoothRent> temp = new ArrayList<>();

            if (assets == null) {
                return BaseOutput.failure("资产不存在");
            }

            List<BoothRent> boothRents = boothRentService.listByExample(query);
            if (CollUtil.isEmpty(boothRents) || (input.getStart() == null || input.getEnd() == null)) {
                return BaseOutput.success().setData(assets.getNumber());
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

                for (BoothRent boothRent : temp) {
                    if (boothRent.getNumber() != null && boothRent.getNumber() > max) {
                        max = boothRent.getNumber();
                    }
                }

                if (canSave) {
                    return BaseOutput.success().setData(assets.getNumber());
                } else {
                    return BaseOutput.success().setData(assets.getNumber() - max);
                }

            }
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            log.error("系统错误", e);
            return BaseOutput.failure("系统错误");
        }
    }

    /**
     * 租赁列表
     */
    @RequestMapping("list")
    public BaseOutput list(@RequestBody BoothRent input) {
        try {
            return BaseOutput.success().setData(boothRentService.listByExample(input));
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        } catch (Exception e) {
            log.error("系统错误", e);
            return BaseOutput.failure("系统错误");
        }
    }

    /**
     * 定时任务
     */
    @RequestMapping(value = "/assetsStatusTask")
    public void assetsStatusTask() {
        // used
        List<BoothRent> rentsUsed = this.boothRentService.selectUsed();
        if (CollUtil.isNotEmpty(rentsUsed)) {
            rentsUsed.forEach(it -> {
                Assets assets = assetsService.get(it.getAssetsId());
                if (assets != null) {
                    assets.setUser(it.getUser());
                    assets.setState(2);
                    assetsService.saveOrUpdate(assets);
                }
            });
        }

        // unUsed
        List<BoothRent> unUsed = this.boothRentService.selectUnUsed();
        List<Long> ids = unUsed.stream().map(BoothRent::getId).collect(Collectors.toList());
        assetsService.updateStateByIdIn(ids);
    }

}