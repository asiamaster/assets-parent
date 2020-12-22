package com.dili.assets.controller;

import com.dili.assets.domain.Assets;
import com.dili.assets.domain.CarType;
import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.service.CarTypeService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.IDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-09 16:44:34.
 */
@Controller
@RequestMapping("/api/carType")
public class CarTypeController {
    @Autowired
    CarTypeService carTypeService;

    /**
     * 跳转到CarType页面
     * @param modelMap
     * @return String
     */
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
    @RequestMapping(value="/listPage", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(@RequestBody CarType carType) throws Exception {
    	if(carType.getKeyword() != null && !"".equals(carType.getKeyword())) {
    		carType.setMetadata(IDTO.AND_CONDITION_EXPR, "( name like '%"+ carType.getKeyword() +"%')");
    	}
    	return carTypeService.listEasyuiPageByExample(carType, true).toString();
    }

    /**
     * 分页查询CarType，返回easyui分页信息
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Object list() throws Exception {
        return carTypeService.listByExample(null);
    }

    /**
     * 分页查询CarType，返回easyui分页信息
     * @param carType
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listCarType", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput<List<CarType>> listCarType(@RequestBody CarTypePublic carType) throws Exception {
    	return BaseOutput.success().setData(carTypeService.listCarType(carType));
    }

    /**
     * 新增CarType
     * @param carType
     * @return BaseOutput
     */
    @RequestMapping(value="/save", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@RequestBody CarType carType) {
        carTypeService.insertCarType(carType);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改CarType
     * @param carType
     * @return BaseOutput
     */
    @RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@RequestBody CarType carType) {
        carTypeService.updateSelective(carType);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除CarType
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(@RequestBody Long id) {
        carTypeService.delete(id);
        return BaseOutput.success("删除成功");
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @RequestMapping("get")
    public @ResponseBody BaseOutput<Assets> get(@RequestBody Long id) {
        return BaseOutput.success().setData(carTypeService.get(id));
    }

    /**
     * 删除carTypePublic
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/checkRepeat", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Boolean checkRepeat(@RequestBody CarType carType) {
    	Boolean b = true;
        List<CarType> list = carTypeService.checkRepeat(carType);
        if(list != null && list.size() > 0) {
        	b = false;
        }else {
        	b = true;
        }
        return b;
    }
}