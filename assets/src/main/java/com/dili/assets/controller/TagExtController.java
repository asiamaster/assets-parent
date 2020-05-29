package com.dili.assets.controller;

import com.dili.assets.domain.TagExt;
import com.dili.assets.service.TagExtService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-22 09:17:48.
 */
@Api("/tagExt")
@Controller
@RequestMapping("/api/tagExt")
public class TagExtController {
    @Autowired
    TagExtService tagExtService;

    /**
     * 跳转到TagExt页面
     * @param modelMap
     * @return String
     */
    @ApiOperation("跳转到TagExt页面")
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "tagExt/index";
    }

    /**
     * 分页查询TagExt，返回easyui分页信息
     * @param tagExt
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询TagExt", notes = "分页查询TagExt，返回easyui分页信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name="TagExt", paramType="form", value = "TagExt的form信息", required = false, dataType = "string")
	})
    @RequestMapping(value="/listPage", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@RequestBody TagExt tagExt) throws Exception {
        return tagExtService.listEasyuiPageByExample(tagExt, true).toString();
    }
    /**
     * 分页查询TagExt，返回easyui分页信息
     * @param tagExt
     * @return String
     * @throws Exception
     */
    @ApiOperation(value="分页查询TagExt", notes = "分页查询TagExt，返回easyui分页信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="TagExt", paramType="form", value = "TagExt的form信息", required = false, dataType = "string")
    })
    @RequestMapping(value="/get", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput<TagExt> get(@RequestBody TagExt tagExt) throws Exception {
    	List<TagExt> list = tagExtService.list(tagExt);
    	return BaseOutput.success().setData(tagExtService.list(tagExt).get(0));
    }

    /**
     * 新增TagExt
     * @param tagExt
     * @return BaseOutput
     */
    @ApiOperation("新增TagExt")
    @ApiImplicitParams({
		@ApiImplicitParam(name="TagExt", paramType="form", value = "TagExt的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@ModelAttribute TagExt tagExt) {
        tagExtService.insertSelective(tagExt);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改TagExt
     * @param tagExt
     * @return BaseOutput
     */
    @ApiOperation("修改TagExt")
    @ApiImplicitParams({
		@ApiImplicitParam(name="TagExt", paramType="form", value = "TagExt的form信息", required = true, dataType = "string")
	})
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@ModelAttribute TagExt tagExt) {
        tagExtService.updateSelective(tagExt);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除TagExt
     * @param id
     * @return BaseOutput
     */
    @ApiOperation("删除TagExt")
    @ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="form", value = "TagExt的主键", required = true, dataType = "long")
	})
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        tagExtService.delete(id);
        return BaseOutput.success("删除成功");
    }
}