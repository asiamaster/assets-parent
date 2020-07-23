package com.dili.assets.sdk.rpc;

import com.alibaba.fastjson.JSONObject;
import com.dili.assets.sdk.dto.*;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "assets-service", url = "${AssetsRpc.url:}")
public interface AssetsRpc {

    /**
     * 获取客户列表信息
     */
    @RequestMapping(value = "/api/category/getTree", method = RequestMethod.POST)
    BaseOutput<List<CategoryDTO>> list(CategoryDTO categoryDTO);

    /**
     * 获取客户列表信息
     */
    @RequestMapping(value = "/api/customCategory/getTree", method = RequestMethod.POST)
    BaseOutput<List<CategoryDTO>> listCusCategory(CategoryDTO categoryDTO);

    /**
     * 新增品类
     */
    @RequestMapping(value = "/api/category/save", method = RequestMethod.POST)
    BaseOutput save(CategoryDTO dto);

    /**
     * 新增品类
     */
    @RequestMapping(value = "/api/customCategory/save", method = RequestMethod.POST)
    BaseOutput saveCusCategory(CustomCategoryDTO dto);

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/api/category/get", method = RequestMethod.POST)
    BaseOutput<CategoryDTO> get(Long id);

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/api/customCategory/get", method = RequestMethod.POST)
    BaseOutput<CustomCategoryDTO> getCusCategory(@RequestParam("id") Long id, @RequestParam("marketId") Long marketId);

    /**
     * 删除品类
     */
    @RequestMapping(value = "/api/category/batchUpdate", method = RequestMethod.POST)
    BaseOutput batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value);

    /**
     * 删除品类
     */
    @RequestMapping(value = "/api/customCategory/batchUpdate", method = RequestMethod.POST)
    BaseOutput batchCusCategoryUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value, @RequestParam("marketId") Long marketId);

    /**
     * 新增摊位
     */
    @RequestMapping(value = "/api/assets/save", method = RequestMethod.POST)
    BaseOutput save(AssetsDTO input);

    /**
     * 获取摊位列表
     */
    @RequestMapping(value = "/api/assets/list", method = RequestMethod.GET)
    String listPage(AssetsDTO input);

    /**
     * 新增区域
     */
    @RequestMapping(value = "/api/district/save", method = RequestMethod.POST)
    BaseOutput addDistrict(DistrictDTO input);

    /**
     * 修改区域
     */
    @RequestMapping(value = "/api/district/edit", method = RequestMethod.POST)
    BaseOutput editDistrict(DistrictDTO input);

    /**
     * 获取区域列表
     */
    @RequestMapping(value = "/api/district/list", method = RequestMethod.GET)
    String listDistrictPage(DistrictDTO input);

    /**
     * 获取单个区域
     */
    @RequestMapping(value = "/api/district/get", method = RequestMethod.POST)
    BaseOutput<DistrictDTO> getDistrictById(Long id);

    /**
     * 删除区域
     */
    @RequestMapping(value = "/api/district/delete", method = RequestMethod.POST)
    BaseOutput delDistrictById(Long id);

    /**
     * 根据ID查询本身和子节点
     */
    @RequestMapping(value = "/api/district/listChild", method = RequestMethod.POST)
    BaseOutput<List<DistrictDTO>> listDistrictChild(Long id);

    /**
     * 拆分区域
     */
    @RequestMapping(value = "/api/district/divisionSave", method = RequestMethod.POST)
    BaseOutput divisionSave(@RequestParam("parentId") Long parentId, @RequestParam("names") String[] names, @RequestParam("notes") String[] notes, @RequestParam("numbers") String[] numbers);

    /**
     * 修改搜索
     */
    @RequestMapping(value = "/api/district/search", method = RequestMethod.POST)
    BaseOutput<List<DistrictDTO>> searchDistrict(DistrictDTO input);

    /**
     * 获取单个摊位
     */
    @RequestMapping(value = "/api/assets/get", method = RequestMethod.POST)
    BaseOutput<AssetsDTO> getBoothById(Long id);

    /**
     * 修改摊位
     */
    @RequestMapping(value = "/api/assets/update", method = RequestMethod.POST)
    BaseOutput updateBooth(AssetsDTO input);

    /**
     * 删除摊位
     */
    @RequestMapping(value = "/api/assets/delete", method = RequestMethod.POST)
    BaseOutput delBoothById(Long id);

    /**
     * 删除摊位
     */
    @RequestMapping(value = "/api/assets/getBoothBalance", method = RequestMethod.POST)
    BaseOutput<Double> getBoothBalance(Long id);

    /**
     * 拆分摊位
     */
    @RequestMapping(value = "/api/assets/split", method = RequestMethod.POST)
    BaseOutput boothSplit(@RequestParam("parentId") Long parentId, @RequestParam("names") String[] names, @RequestParam("notes") String notes, @RequestParam("numbers") String[] numbers);

    /**
     * 搜索摊位
     */
    @RequestMapping(value = "/api/assets/search", method = RequestMethod.POST)
    BaseOutput<List<AssetsDTO>> searchBooth(JSONObject query);

    /**
     * 新增摊位租赁时间，默认为冻结
     */
    @RequestMapping(value = "/api/boothRent/add", method = RequestMethod.POST)
    BaseOutput addBoothRent(BoothRentDTO input);

    /**
     * 根据@param{摊位}和@param{单号}修改出粗状态为已出租
     */
    @RequestMapping(value = "/api/boothRent/rent", method = RequestMethod.POST)
    BaseOutput rentBoothRent(BoothRentDTO input);

    /**
     * 根据@param{摊位}和@param{单号}删除信息
     */
    @RequestMapping(value = "/api/boothRent/delete", method = RequestMethod.POST)
    BaseOutput deleteBoothRent(BoothRentDTO input);

    /**
     * 根据@param{摊位}和@param{单号}修改@param{结束时间}
     */
    @RequestMapping(value = "/api/boothRent/updateEnd", method = RequestMethod.POST)
    BaseOutput updateEndBoothRent(BoothRentDTO input);

    /**
     * 获取车型列表
     */
    @RequestMapping(value = "/api/carType/listPage", method = RequestMethod.GET)
    String listPage(CarTypeDTO input);

    /**
     * 新增车型
     */
    @RequestMapping(value = "/api/carType/save", method = RequestMethod.POST)
    BaseOutput save(CarTypeDTO dto);

    /**
     * 根据@param{车型id}获取车型
     */
    @RequestMapping(value = "/api/carType/get", method = RequestMethod.POST)
    BaseOutput<CarTypeDTO> getCarTypeById(Long id);

    /**
     * 修改车型
     */
    @RequestMapping(value = "/api/carType/update", method = RequestMethod.POST)
    BaseOutput update(CarTypeDTO carType);

    /**
     * 删除车型
     */
    @RequestMapping(value = "/api/carType/delete", method = RequestMethod.POST)
    BaseOutput delete(Long id);

    /**
     * 获取车型列表
     */
    @RequestMapping(value = "/api/carTypePublic/listPage", method = RequestMethod.GET)
    String listPage(CarTypePublicDTO input);

    /**
     * 根据@param{车型id}获取车型
     */
    @RequestMapping(value = "/api/carTypePublic/get", method = RequestMethod.POST)
    BaseOutput getCarTypePublicById(CarTypePublicDTO carTypePublic);

    /**
     * 新增车型
     */
    @RequestMapping(value = "/api/carTypePublic/save", method = RequestMethod.POST)
    BaseOutput save(CarTypePublicDTO dto);

    /**
     * 修改车型
     */
    @RequestMapping(value = "/api/carTypePublic/update", method = RequestMethod.POST)
    BaseOutput update(CarTypePublicDTO carTypePublic);

    /**
     * 修改车型状态
     */
    @RequestMapping(value = "/api/carTypePublic/updateStatus", method = RequestMethod.POST)
    BaseOutput updateStatus(CarTypePublicDTO carTypePublic);

    /**
     * 删除车型
     */
    @RequestMapping(value = "/api/carTypePublic/deleteTagExt", method = RequestMethod.POST)
    BaseOutput deleteTagExt(CarTypePublicDTO carTypePublic);

    /**
     * 获取客户列表信息
     */
    @RequestMapping(value = "/api/subject/getTree", method = RequestMethod.POST)
    BaseOutput<List<SubjectDTO>> listSubject(SubjectQuery query);

    /**
     * 获取客户列表信息
     */
    @RequestMapping(value = "/api/subject/getTree", method = RequestMethod.POST)
    BaseOutput<List<SubjectDTO>> listSubject(SubjectDTO query);

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/api/subject/get", method = RequestMethod.POST)
    BaseOutput<SubjectDTO> getSubject(Long id);

    /**
     * 新增品类
     */
    @RequestMapping(value = "/api/subject/save", method = RequestMethod.POST)
    BaseOutput save(SubjectDTO dto);

    /**
     * 删除品类
     */
    @RequestMapping(value = "/api/subject/batchUpdate", method = RequestMethod.POST)
    BaseOutput batchUpdateSubject(@RequestParam("id") Long id, @RequestParam("value") Integer value);
}
