package com.dili.assets.controller;

import com.dili.assets.domain.CarType;
import com.dili.assets.service.CarTypeService;
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
 * This file was generated on 2020-05-09 16:44:34.
 */
@Api("/carType")
@Controller
@RequestMapping("/carType")
public class CarTypeController {
    @Autowired
    CarTypeService carTypeService;

    /**
     * 跳转到CarType页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到CarType页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "carType/index";
    }

    /**
     * 分页查询CarType，返回easyui分页信息
     * @param carType
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询CarType", notes = "分页查询CarType，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CarType", paramType="form", value = "CarType的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute CarType carType) throws Exception {
        return carTypeService.listEasyuiPageByExample(carType, true).toString();
    }

    /**
     * 新增CarType
     * @param carType
     * @return BaseOutput
     */
    @ApiOperation("新增CarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CarType", paramType="form", value = "CarType的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute CarType carType) {
        carTypeService.insertSelective(carType);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改CarType
     * @param carType
     * @return BaseOutput
     */
    @ApiOperation("修改CarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CarType", paramType="form", value = "CarType的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute CarType carType) {
        carTypeService.updateSelective(carType);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除CarType
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除CarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "CarType的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        carTypeService.delete(id);
        return BaseOutput.success("删除成功");
    }
}