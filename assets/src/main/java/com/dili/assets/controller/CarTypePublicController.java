package com.dili.assets.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.TagExt;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.assets.sdk.dto.CarTypeForBusinessDTO;
import com.dili.assets.service.CarTypePublicService;
import com.dili.assets.service.TagExtService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.PageOutput;
import com.dili.ss.dto.DTOUtils;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 14:41:03.
 */
@Controller
@RequestMapping("/api/carTypePublic")
public class CarTypePublicController {
    @Autowired
    CarTypePublicService carTypePublicService;
    @Autowired
    TagExtService tagExtService;
    @Autowired
    private DataDictionaryRpc dataDictionaryRpc;
    /**
     * 跳转到carTypePublic页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "carTypePublic/index";
    }

    /**
     * 分页查询carTypePublic，返回easyui分页信息
     * @param carTypePublic
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody PageOutput listPage(@RequestBody CarTypePublicQuery carTypePublic) throws Exception {
    	DataDictionaryValue dataDictionaryValue = DTOUtils.newInstance(DataDictionaryValue.class);
    	dataDictionaryValue.setDdCode("cartype_tag");
    	dataDictionaryValue.setFirmId(carTypePublic.getMarketId());
    	Integer page = carTypePublic.getPage();
		page = (page == null) ? Integer.valueOf(1) : page;
		if(carTypePublic.getRows() != null && carTypePublic.getRows() >= 1) {
			//为了线程安全,请勿改动下面两行代码的顺序
			PageHelper.startPage(page, carTypePublic.getRows());
		}
		
    	List<DataDictionaryValue> list = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue).getData();
    	carTypePublic.setTags(list);
    	List<Map<String, Object>> listCarTypePublic = carTypePublicService.listCarTypePublic(carTypePublic, true);
    	 //总记录
        Long total = listCarTypePublic instanceof Page ? ((Page) listCarTypePublic).getTotal() : listCarTypePublic.size();
        //总页数
        int totalPage = listCarTypePublic instanceof Page ? ((Page) listCarTypePublic).getPages() : 1;
        //当前页数
        int pageNum = listCarTypePublic instanceof Page ? ((Page) listCarTypePublic).getPageNum() : 1;
        PageOutput output = PageOutput.success();
        output.setData(listCarTypePublic).setPageNum(pageNum).setTotal(total.intValue()).setPageSize(carTypePublic.getPage()).setPages(totalPage);
        return output;
    }
    /**
     * 分页查询carTypePublic，返回easyui分页信息
     * @param carTypePublic
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listCarTypePublic", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput<List<Map<String, Object>>> listCarTypePublic(@RequestBody CarTypePublicQuery carTypePublic) throws Exception {
    	DataDictionaryValue dataDictionaryValue = DTOUtils.newInstance(DataDictionaryValue.class);
    	dataDictionaryValue.setDdCode("cartype_tag");
    	dataDictionaryValue.setId(carTypePublic.getMarketId());
    	
    	List<DataDictionaryValue> list = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue).getData();
    	carTypePublic.setTags(list);
    	return BaseOutput.success().setData(carTypePublicService.listCarTypePublicByTruck(carTypePublic));
    }
    
    /**
     * 查询carTypePublic
     * @param carTypePublic
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listCarTypePublicByBusiness", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput<List<CarTypeForBusinessDTO>> listCarTypePublicByBusiness(@RequestBody CarTypePublicQuery carTypePublic) throws Exception {
    	
    	return BaseOutput.success().setData(carTypePublicService.listCarTypePublicByBusiness(carTypePublic));
    }

    /**
     * 新增carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @RequestMapping(value="/save", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(@RequestBody CarTypePublic carTypePublic) {
    	try {
    		carTypePublicService.insertSelective(carTypePublic);
    		List<TagExt> tagExt = carTypePublic.getTagExt();
            for (TagExt te : tagExt) {
				te.setCarTypePublicId(carTypePublic.getId());
			}
            tagExtService.batchInsert(tagExt);
            return BaseOutput.success("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return BaseOutput.success("新增失败");
		}
        
    }

    /**
     * 修改carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(@RequestBody CarTypePublic carTypePublic) {
    	if(carTypePublic.getTagExt() != null && carTypePublic.getTagExt().size() > 0) {
    		tagExtService.batchInsert(carTypePublic.getTagExt());
    	}
        carTypePublicService.updateCarTypePublic(carTypePublic);
        return BaseOutput.success("修改成功");
    }
    /**
     * 修改carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @RequestMapping(value="/updateStatus", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput updateStatus(@RequestBody CarTypePublic carTypePublic) {
    	carTypePublicService.updateSelective(carTypePublic);
    	return BaseOutput.success("修改成功");
    }
    
    /**
     * 修改carTypePublic
     * @param carTypePublic
     * @return BaseOutput
     */
    @RequestMapping(value="/updateStatusByCarTypeId", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput updateStatusByCarTypeId(@RequestBody CarTypePublic carTypePublic) {
    	carTypePublicService.updateStatusByCarTypeId(carTypePublic);
    	return BaseOutput.success("修改成功");
    }

    /**
     * 删除carTypePublic
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        carTypePublicService.delete(id);
        return BaseOutput.success("删除成功");
    }
    /**
     * 删除carTypePublic
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/deleteTagExt", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput deleteTagExt(@RequestBody CarTypePublicQuery carTypePublic) {
    	carTypePublicService.deleteTagExt(carTypePublic);
    	return BaseOutput.success("删除成功");
    }
    
    /**
     * 获取
     *
     * @param id
     * @return
     */
    @RequestMapping("get")
    public @ResponseBody BaseOutput get(@RequestBody CarTypePublicQuery carTypePublic) {
        return BaseOutput.success().setData(carTypePublicService.getCarTypePublicById(carTypePublic).get(0));
    }
    
    /**
     * 查询carTypePublic
     * @param carTypePublic
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/queryCarType", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput<List<CarTypeForBusinessDTO>> queryCarType(@RequestBody CarTypePublicQuery carTypePublic) throws Exception {
    	
    	return BaseOutput.success().setData(carTypePublicService.queryCarType(carTypePublic));
    }
    
    /**
     * 删除carTypePublic
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/checkRepeat", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Boolean checkRepeat(@RequestBody CarTypePublic carTypePublic) {
    	Boolean b = true;
        List<CarTypePublic> list = carTypePublicService.checkRepeat(carTypePublic);
        if(list != null && list.size() > 0) {
        	b = false;
        }else {
        	b = true;
        }
        return b;
    }
}