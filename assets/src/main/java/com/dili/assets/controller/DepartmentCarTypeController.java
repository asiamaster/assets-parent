package com.dili.assets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dili.assets.domain.DepartmentCarType;
import com.dili.assets.service.CarTypeService;
import com.dili.assets.service.DepartmentCarTypeService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-12 10:33:30.
 */
@Api("/departmentCarType")
@Controller
@RequestMapping("/api/departmentCarType")
public class DepartmentCarTypeController {
    @Autowired
    DepartmentCarTypeService departmentCarTypeService;
    @Autowired
    CarTypeService carTypeService;

    /**
     * 跳转到DepartmentCarType页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到DepartmentCarType页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "departmentCarType/index";
    }

    /**
     * 分页查询DepartmentCarType，返回easyui分页信息
     * @param departmentCarType
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询DepartmentCarType", notes = "分页查询DepartmentCarType，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="DepartmentCarType", paramType="form", value = "DepartmentCarType的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@RequestBody DepartmentCarType departmentCarType) throws Exception {
        return departmentCarTypeService.listEasyuiPageByExample(departmentCarType, true).toString();
    }

    /**
     * 新增DepartmentCarType
     * @param departmentCarType
     * @return BaseOutput
     */
    @ApiOperation("新增DepartmentCarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="DepartmentCarType", paramType="form", value = "DepartmentCarType的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@RequestBody DepartmentCarType departmentCarType) {
        departmentCarTypeService.insertSelective(departmentCarType);
        return BaseOutput.success("新增成功");
    }
    
    /**
     * 新增DepartmentCarType
     * @param departmentCarType
     * @return BaseOutput
     */
    @ApiOperation("新增DepartmentCarType")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="DepartmentCarType", paramType="form", value = "DepartmentCarType的form信息", required = true, dataType = "string")
    })
    @RequestMapping(value="/batchInsert", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput batchInsert(@RequestBody List<DepartmentCarType> list) {
    	departmentCarTypeService.batchInsert(list);
    	
    	return BaseOutput.success("新增成功");
    }

    /**
     * 修改DepartmentCarType
     * @param departmentCarType
     * @return BaseOutput
     */
    @ApiOperation("修改DepartmentCarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="DepartmentCarType", paramType="form", value = "DepartmentCarType的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@RequestBody DepartmentCarType departmentCarType) {
        departmentCarTypeService.updateSelective(departmentCarType);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除DepartmentCarType
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除DepartmentCarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "DepartmentCarType的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(@RequestBody Long id) {
        departmentCarTypeService.delete(id);
        return BaseOutput.success("删除成功");
    }
    
    @RequestMapping("/getDepartmentCarTypeByDepartmentId")
    @ResponseBody
    public BaseOutput getDepartmentCarTypeByDepartmentId(@RequestBody Long departmentId) {
    	Map<String, Object> map = new HashMap<>();
        try {
        	List<DepartmentCarType> result = departmentCarTypeService.list(departmentId);
            return BaseOutput.success().setData(result);
       } catch (BusinessException be) {
           return BaseOutput.failure(be.getErrorMsg());
       }
    }
    /**
     * 删除DepartmentCarType
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除DepartmentCarType")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "DepartmentCarType的部门id", required = true, dataType = "long")
	})
    @RequestMapping(value="/deleteByDepartmentId", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput deleteByDepartmentId(@RequestBody Long id) {
        departmentCarTypeService.deleteByDepartmentId(id);
        return BaseOutput.success("删除成功");
    }
}