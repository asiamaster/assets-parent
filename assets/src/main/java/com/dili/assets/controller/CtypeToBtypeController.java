package com.dili.assets.controller;

import com.dili.assets.domain.CtypeToBtype;
import com.dili.assets.service.CtypeToBtypeService;
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
 * This file was generated on 2020-05-09 17:43:57.
 */
@Api("/ctypeToBtype")
@Controller
@RequestMapping("/ctypeToBtype")
public class CtypeToBtypeController {
    @Autowired
    CtypeToBtypeService ctypeToBtypeService;

    /**
     * 跳转到CtypeToBtype页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到CtypeToBtype页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "ctypeToBtype/index";
    }

    /**
     * 分页查询CtypeToBtype，返回easyui分页信息
     * @param ctypeToBtype
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询CtypeToBtype", notes = "分页查询CtypeToBtype，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CtypeToBtype", paramType="form", value = "CtypeToBtype的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute CtypeToBtype ctypeToBtype) throws Exception {
        return ctypeToBtypeService.listEasyuiPageByExample(ctypeToBtype, true).toString();
    }

    /**
     * 新增CtypeToBtype
     * @param ctypeToBtype
     * @return BaseOutput
     */
    @ApiOperation("新增CtypeToBtype")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CtypeToBtype", paramType="form", value = "CtypeToBtype的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute CtypeToBtype ctypeToBtype) {
        ctypeToBtypeService.insertSelective(ctypeToBtype);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改CtypeToBtype
     * @param ctypeToBtype
     * @return BaseOutput
     */
    @ApiOperation("修改CtypeToBtype")
    @ApiImplicitParams({
		@ApiImplicitParam(name="CtypeToBtype", paramType="form", value = "CtypeToBtype的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute CtypeToBtype ctypeToBtype) {
        ctypeToBtypeService.updateSelective(ctypeToBtype);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除CtypeToBtype
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除CtypeToBtype")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "CtypeToBtype的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        ctypeToBtypeService.delete(id);
        return BaseOutput.success("删除成功");
    }
}