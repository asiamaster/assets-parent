package com.dili.assets.controller;

import com.dili.assets.domain.ProductRule;
import com.dili.assets.service.ProductRuleService;
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
 * This file was generated on 2020-05-12 10:35:09.
 */
@Api("/productRule")
@Controller
@RequestMapping("/productRule")
public class ProductRuleController {
    @Autowired
    ProductRuleService productRuleService;

    /**
     * 跳转到ProductRule页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到ProductRule页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "productRule/index";
    }

    /**
     * 分页查询ProductRule，返回easyui分页信息
     * @param productRule
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询ProductRule", notes = "分页查询ProductRule，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="ProductRule", paramType="form", value = "ProductRule的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute ProductRule productRule) throws Exception {
        return productRuleService.listEasyuiPageByExample(productRule, true).toString();
    }

    /**
     * 新增ProductRule
     * @param productRule
     * @return BaseOutput
     */
    @ApiOperation("新增ProductRule")
    @ApiImplicitParams({
		@ApiImplicitParam(name="ProductRule", paramType="form", value = "ProductRule的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute ProductRule productRule) {
        productRuleService.insertSelective(productRule);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改ProductRule
     * @param productRule
     * @return BaseOutput
     */
    @ApiOperation("修改ProductRule")
    @ApiImplicitParams({
		@ApiImplicitParam(name="ProductRule", paramType="form", value = "ProductRule的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute ProductRule productRule) {
        productRuleService.updateSelective(productRule);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除ProductRule
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除ProductRule")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "ProductRule的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        productRuleService.delete(id);
        return BaseOutput.success("删除成功");
    }
}