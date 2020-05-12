package com.dili.assets.controller;

import com.dili.assets.domain.productRuleRecord;
import com.dili.assets.service.productRuleRecordService;
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
 * This file was generated on 2020-05-12 10:35:29.
 */
@Api("/productRuleRecord")
@Controller
@RequestMapping("/productRuleRecord")
public class productRuleRecordController {
    @Autowired
    productRuleRecordService productRuleRecordService;

    /**
     * 跳转到productRuleRecord页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到productRuleRecord页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "productRuleRecord/index";
    }

    /**
     * 分页查询productRuleRecord，返回easyui分页信息
     * @param productRuleRecord
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询productRuleRecord", notes = "分页查询productRuleRecord，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="productRuleRecord", paramType="form", value = "productRuleRecord的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@ModelAttribute productRuleRecord productRuleRecord) throws Exception {
        return productRuleRecordService.listEasyuiPageByExample(productRuleRecord, true).toString();
    }

    /**
     * 新增productRuleRecord
     * @param productRuleRecord
     * @return BaseOutput
     */
    @ApiOperation("新增productRuleRecord")
    @ApiImplicitParams({
		@ApiImplicitParam(name="productRuleRecord", paramType="form", value = "productRuleRecord的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute productRuleRecord productRuleRecord) {
        productRuleRecordService.insertSelective(productRuleRecord);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改productRuleRecord
     * @param productRuleRecord
     * @return BaseOutput
     */
    @ApiOperation("修改productRuleRecord")
    @ApiImplicitParams({
		@ApiImplicitParam(name="productRuleRecord", paramType="form", value = "productRuleRecord的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute productRuleRecord productRuleRecord) {
        productRuleRecordService.updateSelective(productRuleRecord);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除productRuleRecord
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除productRuleRecord")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "productRuleRecord的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        productRuleRecordService.delete(id);
        return BaseOutput.success("删除成功");
    }
}