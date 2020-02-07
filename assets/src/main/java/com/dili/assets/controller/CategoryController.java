package com.dili.assets.controller;

import com.dili.assets.domain.Category;
import com.dili.assets.service.CategoryService;
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
 * This file was generated on 2020-02-05 12:37:16.
 */
@Api("/category")
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 跳转到Category页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到Category页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "category/index";
    }

    /**
     * 分页查询Category，返回easyui分页信息
     * @param category
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询Category", notes = "分页查询Category，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Category", paramType="form", value = "Category的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(Category category) throws Exception {
        return categoryService.listEasyuiPageByExample(category, true).toString();
    }

    /**
     * 新增Category
     * @param customer
     * @return BaseOutput
     */
    @ApiOperation("新增Category")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Category", paramType="form", value = "Category的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(Category category) {
        categoryService.insertSelective(category);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Category
     * @param customer
     * @return BaseOutput
     */
    @ApiOperation("修改Category")
    @ApiImplicitParams({
		@ApiImplicitParam(name="Category", paramType="form", value = "Category的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(Category category) {
        categoryService.updateSelective(category);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Category
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除Category")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "Category的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        categoryService.delete(id);
        return BaseOutput.success("删除成功");
    }
}