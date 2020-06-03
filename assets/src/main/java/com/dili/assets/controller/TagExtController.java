package com.dili.assets.controller;

import com.dili.assets.domain.TagExt;
import com.dili.assets.service.TagExtService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-22 09:17:48.
 */
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
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        tagExtService.delete(id);
        return BaseOutput.success("删除成功");
    }
}