package com.dili.assets.controller;

import com.dili.assets.domain.Booth;
import com.dili.assets.service.BoothService;
import com.dili.ss.domain.BaseOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@Api("/booth")
@Controller
@RequestMapping("/booth")
public class BoothController {
    @Autowired
    BoothService boothService;

    /**
     * 跳转到Booth页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到Booth页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "booth/index";
    }

    /**
     * 分页查询Booth，返回easyui分页信息
     * @param booth
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询Booth", notes = "分页查询Booth，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Booth", paramType="form", value = "Booth的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(Booth booth) throws Exception {
        return boothService.listEasyuiPageByExample(booth, true).toString();
    }

    /**
     * 新增Booth
     * @param booth
     * @return BaseOutput
     */
    @ApiOperation("新增Booth")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Booth", paramType="form", value = "Booth的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(Booth booth) {
        boothService.insertSelective(booth);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Booth
     * @param booth
     * @return BaseOutput
     */
    @ApiOperation("修改Booth")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Booth", paramType="form", value = "Booth的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(Booth booth) {
        boothService.updateSelective(booth);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Booth
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除Booth")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "Booth的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        boothService.delete(id);
        return BaseOutput.success("删除成功");
    }
}