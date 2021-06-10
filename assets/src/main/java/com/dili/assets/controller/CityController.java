package com.dili.assets.controller;

import com.dili.assets.domain.City;
import com.dili.assets.domain.query.CityQuery;
import com.dili.assets.sdk.dto.CityKeyWordsQueryDto;
import com.dili.assets.sdk.enums.CityCountryQueryType;
import com.dili.assets.service.CityService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.IDTO;
import com.dili.ss.util.BeanConver;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        CityQuery query = BeanConver.copyBean(city, CityQuery.class);
        return this.listByExample(query);
    }

    /**
     * 城市查询接口
     *
     * @param city
     * @return
     */
    @PostMapping("/listByExample")
    public BaseOutput<List<City>> listByExample(@RequestBody CityQuery city) {
        if (city.getCountryQueryType().equals(CityCountryQueryType.INTERNAL.getValue())) {
            city.setMetadata(IDTO.AND_CONDITION_EXPR, "id < 1000000");
        } else if (city.getCountryQueryType().equals(CityCountryQueryType.ABROAD.getValue())) {
            city.setMetadata(IDTO.AND_CONDITION_EXPR, "id >= 1000000");
        }
        return BaseOutput.success().setData(this.cityService.listByExample(city));
    }

    /**
     * 城市查询接口
     * 简拼，全拼，汉字简称，汉字全称，地址级别，查询地址数据
     *
     * @param city
     * @return
     */
    @PostMapping("/listByKeywords")
    public BaseOutput<List<City>> listByKeywords(@RequestBody CityKeyWordsQueryDto city) {
        if (StringUtils.isNotBlank(city.getAllLevelKeyword())
                && (StringUtils.isNotBlank(city.getFirstKeyword())
                || StringUtils.isNotBlank(city.getSecondKeyword())
                || StringUtils.isNotBlank(city.getThirdKeyword()))) {
            return BaseOutput.failure("按所有行政级别关键字查询时，其他各级区划查询关键字必须为空");
        }
        if (StringUtils.isBlank(city.getAllLevelKeyword()) && StringUtils.isBlank(city.getFirstKeyword())) {
            return BaseOutput.failure("第一级参数不能为空");
        }
        List<City> cities = cityService.listByKeywords(city);
        return BaseOutput.success().setData(cities);
    }

    /**
     * 根据id查询城市接口
     *
     * @param id
     * @return
     */
    @PostMapping("/getById")
    public BaseOutput<City> getById(@RequestParam("id") Long id) {
        City city = cityService.get(id);
        return BaseOutput.success().setData(city);
    }
}