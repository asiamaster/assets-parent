package com.dili.assets.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2018-05-22 16:24:56.
 */
@Api("/assets")
@Controller
@RequestMapping("/assets")
public class AssetsController {

    /**
     * 跳转到资产管理页面
     *
     * @param modelMap
     * @return
     */
    @ApiOperation("跳转到资产管理页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "assets/index";
    }
}