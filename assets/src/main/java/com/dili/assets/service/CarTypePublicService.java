package com.dili.assets.service;

import java.util.List;
import java.util.Map;

import com.dili.assets.domain.CarTypePublic;
import com.dili.assets.domain.query.CarTypePublicQuery;
import com.dili.assets.sdk.dto.CarTypeForBusinessDTO;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-18 14:41:03.
 */
public interface CarTypePublicService extends BaseService<CarTypePublic, Long> {

	/**
	 * 分页查询公共车型
	 * @param carTypePublic 公共车型实体类
	 * @param b
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> listCarTypePublic(CarTypePublicQuery carTypePublic, boolean b) throws Exception;

	/**
	 * 通过车型id车型车型
	 * @param carTypePublic 公共车型实体类
	 * @return
	 */
	List<Map<String, Object>> getCarTypePublicById(CarTypePublicQuery carTypePublic);

	/**
	 * 公共车型更新
	 * @param carTypePublic 公共车型实体类
	 */
	void updateCarTypePublic(CarTypePublic carTypePublic);

	/**
	 * 删除公共车型对应的标签
	 * @param carTypePublic 公共车型实体类
	 */
	void deleteTagExt(CarTypePublicQuery carTypePublic);

	/**
	 * 进门收费注册车辆信息车型公共车型列表
	 * @param carTypePublic 公共车型实体类
	 */
	List<Map<String, Object>> listCarTypePublicByTruck(CarTypePublicQuery carTypePublic);
	
	/**
	 * 提供给业务系统使用的获取车型
	 * @param carTypePublic 公共车型实体类
	 */
	List<CarTypeForBusinessDTO> listCarTypePublicByBusiness(CarTypePublicQuery carTypePublic);

	/**
	 * 提供给业务系统使用的获取车型（不包含标签的内容）
	 * @param carTypePublic 公共车型实体类
	 */
	List<CarTypeForBusinessDTO> queryCarType(CarTypePublicQuery carTypePublic);

	/**
     * 检车快捷编码是否重复
     */
	List<CarTypePublic> checkRepeat(CarTypePublic carTypePublic);

	/**
     * 通过基础车型id修改车型状态
     */
	void updateStatusByCarTypeId(CarTypePublic carTypePublic);

}