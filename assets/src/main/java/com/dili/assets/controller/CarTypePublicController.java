package com.dili.assets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.service.CarTypePublicService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.EasyuiPageOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 14:41:03.
 */
@Api("/carTypePublic")
@Controller
@RequestMapping("/api/carTypePublic")
public class CarTypePublicController {
    @Autowired
    CarTypePublicService carTypePublicService;

    /**
     * 跳转到carTypePublic页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到carTypePublic页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "carTypePublic/index";
    }

    /**
     * 分页查询carTypePublic，返回easyui分页信息
     * @param carTypePublic
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询carTypePublic", notes = "分页查询carTypePublic，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="carTypePublic", paramType="form", value = "carTypePublic的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@RequestBody CarTypePublic carTypePublic) throws Exception {
        return carTypePublicService.listCarTypePublic(carTypePublic, true);
    }

    /**
     * 新增carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @ApiOperation("新增carTypePublic")
    @ApiImplicitParams({
		@ApiImplicitParam(name="carTypePublic", paramType="form", value = "carTypePublic的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute CarTypePublic carTypePublic) {
        carTypePublicService.insertSelective(carTypePublic);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @ApiOperation("修改carTypePublic")
    @ApiImplicitParams({
		@ApiImplicitParam(name="carTypePublic", paramType="form", value = "carTypePublic的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute CarTypePublic carTypePublic) {
        carTypePublicService.updateSelective(carTypePublic);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除carTypePublic
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除carTypePublic")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "carTypePublic的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        carTypePublicService.delete(id);
        return BaseOutput.success("删除成功");
    }
}