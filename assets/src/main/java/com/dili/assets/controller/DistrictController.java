package com.dili.assets.controller;

import com.dili.assets.domain.District;
import com.dili.assets.service.DistrictService;
import com.dili.ss.domain.BaseOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@Api("/district")
@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    /**
     * 跳转到District页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到District页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "district/index";
    }

    /**
     * 分页查询District，返回easyui分页信息
     * @param district
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询District", notes = "分页查询District，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="District", paramType="form", value = "District的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(District district) throws Exception {
        return districtService.listEasyuiPageByExample(district, true).toString();
    }

    /**
     * 新增District
     * @param district
     * @return BaseOutput
     */
    @ApiOperation("新增District")
    @ApiImplicitParams({
		@ApiImplicitParam(name="District", paramType="form", value = "District的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(District district) {
        districtService.insertSelective(district);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改District
     * @param district
     * @return BaseOutput
     */
    @ApiOperation("修改District")
    @ApiImplicitParams({
		@ApiImplicitParam(name="District", paramType="form", value = "District的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(District district) {
        districtService.updateSelective(district);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除District
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除District")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "District的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        districtService.delete(id);
        return BaseOutput.success("删除成功");
    }
}