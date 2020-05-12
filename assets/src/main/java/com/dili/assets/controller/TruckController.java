package com.dili.assets.controller;

import com.dili.assets.domain.Truck;
import com.dili.assets.service.TruckService;
import com.dili.ss.domain.BaseOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:33:52.
 */
@Api("/truck")
@Controller
@RequestMapping("/truck")
public class TruckController {
    @Autowired
    TruckService truckService;

    /**
     * 跳转到Truck页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到Truck页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "truck/index";
    }

    /**
     * 分页查询Truck，返回easyui分页信息
     * @param truck
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询Truck", notes = "分页查询Truck，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Truck", paramType="form", value = "Truck的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute Truck truck) throws Exception {
        return truckService.listEasyuiPageByExample(truck, true).toString();
    }

    /**
     * 新增Truck
     * @param truck
     * @return BaseOutput
     */
    @ApiOperation("新增Truck")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Truck", paramType="form", value = "Truck的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute Truck truck) {
        truckService.insertSelective(truck);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Truck
     * @param truck
     * @return BaseOutput
     */
    @ApiOperation("修改Truck")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Truck", paramType="form", value = "Truck的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute Truck truck) {
        truckService.updateSelective(truck);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Truck
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除Truck")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "Truck的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        truckService.delete(id);
        return BaseOutput.success("删除成功");
    }
}