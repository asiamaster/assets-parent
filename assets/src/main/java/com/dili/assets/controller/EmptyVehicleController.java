package com.dili.assets.controller;

import com.dili.assets.domain.EmptyVehicle;
import com.dili.assets.service.EmptyVehicleService;
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
 * This file was generated on 2020-05-12 10:34:12.
 */
@Api("/emptyVehicle")
@Controller
@RequestMapping("/emptyVehicle")
public class EmptyVehicleController {
    @Autowired
    EmptyVehicleService emptyVehicleService;

    /**
     * 跳转到EmptyVehicle页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到EmptyVehicle页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "emptyVehicle/index";
    }

    /**
     * 分页查询EmptyVehicle，返回easyui分页信息
     * @param emptyVehicle
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询EmptyVehicle", notes = "分页查询EmptyVehicle，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="EmptyVehicle", paramType="form", value = "EmptyVehicle的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute EmptyVehicle emptyVehicle) throws Exception {
        return emptyVehicleService.listEasyuiPageByExample(emptyVehicle, true).toString();
    }

    /**
     * 新增EmptyVehicle
     * @param emptyVehicle
     * @return BaseOutput
     */
    @ApiOperation("新增EmptyVehicle")
    @ApiImplicitParams({
		@ApiImplicitParam(name="EmptyVehicle", paramType="form", value = "EmptyVehicle的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute EmptyVehicle emptyVehicle) {
        emptyVehicleService.insertSelective(emptyVehicle);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改EmptyVehicle
     * @param emptyVehicle
     * @return BaseOutput
     */
    @ApiOperation("修改EmptyVehicle")
    @ApiImplicitParams({
		@ApiImplicitParam(name="EmptyVehicle", paramType="form", value = "EmptyVehicle的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute EmptyVehicle emptyVehicle) {
        emptyVehicleService.updateSelective(emptyVehicle);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除EmptyVehicle
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除EmptyVehicle")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "EmptyVehicle的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        emptyVehicleService.delete(id);
        return BaseOutput.success("删除成功");
    }
}