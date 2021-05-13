package com.dili.assets.controller;

import com.dili.assets.domain.City;
import com.dili.assets.domain.query.CityQuery;
import com.dili.assets.sdk.enums.CityCountryQueryType;
import com.dili.assets.service.CityService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.IDTO;
import com.dili.ss.util.BeanConver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}