package com.dili.assets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dili.assets.domain.City;
import com.dili.assets.service.CityService;
import com.dili.ss.domain.BaseOutput;

/**
 * 由MyBatis Generator工具自动生成 This file was generated on 2020-05-21 15:27:39.
 */
@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	CityService cityService;

	/**
	 * 城市查询接口
	 * 
	 * @param city
	 * @return
	 */
	@PostMapping("/list")
	public BaseOutput<List<City>> list(@RequestBody City city) {
		return BaseOutput.success().setData(this.cityService.list(city));
	}

	/**
	 * 城市查询接口
	 *
	 * @param city
	 * @return
	 */
	@PostMapping("/listByExample")
	public BaseOutput<List<City>> listByExample(@RequestBody City city) {
		return BaseOutput.success().setData(this.cityService.listByExample(city));
	}
}