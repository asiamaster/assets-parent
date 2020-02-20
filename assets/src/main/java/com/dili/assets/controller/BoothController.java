package com.dili.assets.controller;

import com.dili.assets.domain.Booth;
import com.dili.assets.service.BoothService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@RestController
@RequestMapping("/api/booth")
public class BoothController {
    @Autowired
    BoothService boothService;

    /**
     * 新增摊位
     *
     * @param booth
     * @return
     */
    @RequestMapping("save")
    public BaseOutput save(@RequestBody Booth booth) {
        boothService.saveBooth(booth);
        return BaseOutput.success();
    }

    /**
     * 获取摊位列表
     *
     * @param booth
     * @return
     */
    @RequestMapping("list")
    public String list(Booth booth) {
        return boothService.listForPage(booth);
    }
}