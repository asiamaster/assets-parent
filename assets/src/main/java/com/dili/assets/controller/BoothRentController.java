package com.dili.assets.controller;

import com.dili.assets.domain.BoothRent;
import com.dili.assets.service.BoothRentService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-03-03 14:37:36.
 */
@RestController
@RequestMapping("/api/boothRent")
public class BoothRentController {
    @Autowired
    BoothRentService boothRentService;

    @RequestMapping("add")
    public BaseOutput add(@RequestBody BoothRent input) {
        try {
            boothRentService.add(input);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure("系统错误");
        }
        return BaseOutput.success();
    }
}