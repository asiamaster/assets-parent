package com.dili.assets.service.impl;

import com.dili.assets.domain.City;
import com.dili.assets.mapper.CityMapper;
import com.dili.assets.sdk.dto.CityDto;
import com.dili.assets.sdk.dto.CityKeyWordsQueryDto;
import com.dili.assets.service.CityService;
import com.dili.ss.base.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-21 15:27:39.
 */
@Service
public class CityServiceImpl extends BaseServiceImpl<City, Long> implements CityService {

    public CityMapper getActualDao() {
        return (CityMapper) getDao();
    }

    @Override
    public List<City> listByKeywords(CityKeyWordsQueryDto city) {
        List<City> cities = new ArrayList<>();
        Set<Long> cityIds;
        // 根据关键字全级模糊查询
        if (StringUtils.isNotBlank(city.getAllLevelKeyword())) {
            List<City> allLevelCities = getActualDao().listByAllLevelTypeKeywords(city.getAllLevelKeyword());
            if (CollectionUtils.isEmpty(allLevelCities)) {
                return cities;
            }
            // 分别过滤出国内和国外第一级
            List<City> firstLevelDomesticCities = allLevelCities.stream().filter(c -> c.getId() < 10000000 && c.getLevelType() == 1)
                    .collect(Collectors.toList());
            List<City> firstLevelForeignCities = allLevelCities.stream().filter(c -> c.getId() >= 10000000 && c.getLevelType() == 0)
                    .collect(Collectors.toList());
            // 获取所有一级城市
            List<City> firstLevelCities = new ArrayList<>();
            firstLevelCities.addAll(firstLevelDomesticCities);
            firstLevelCities.addAll(firstLevelForeignCities);
            // 获取所有一级城市id
            Set<Long> firstLevelCityIds = firstLevelCities.stream().map(City::getId).collect(Collectors.toSet());
            // 获取一级城市id下所有的二级城市
            List<City> secondLevelCities = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(firstLevelCityIds)) {
                secondLevelCities = getActualDao().listByParentIds(firstLevelCityIds);
            }
            // 过滤出allLevelCities中的二级城市
            List<City> secondLevelDomesticCities = allLevelCities.stream().filter(c -> c.getId() < 10000000 && c.getLevelType() == 2)
                    .collect(Collectors.toList());
            List<City> secondLevelForeignCities = allLevelCities.stream().filter(c -> c.getId() >= 10000000 && c.getLevelType() == 1)
                    .collect(Collectors.toList());
            secondLevelCities.addAll(secondLevelDomesticCities);
            secondLevelCities.addAll(secondLevelForeignCities);
            // 得到所有二级城市的id
            Set<Long> secondLevelCityIds = secondLevelCities.stream().map(City::getId).collect(Collectors.toSet());
            // 获取二级城市id下所有的三级城市
            List<City> thirdLevelCities = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(secondLevelCityIds)) {
                thirdLevelCities = getActualDao().listByParentIds(secondLevelCityIds);
            }
            // 过滤出allLevelCities中的三级城市
            List<City> thirdLevelDomesticCities = allLevelCities.stream().filter(c -> c.getId() < 10000000 && c.getLevelType() == 3)
                    .collect(Collectors.toList());
            List<City> thirdLevelForeignCities = allLevelCities.stream().filter(c -> c.getId() >= 10000000 && c.getLevelType() == 2)
                    .collect(Collectors.toList());
            thirdLevelCities.addAll(thirdLevelDomesticCities);
            thirdLevelCities.addAll(thirdLevelForeignCities);
            // 将三级城市合并，去重，排序
            cities.addAll(firstLevelCities);
            cities.addAll(secondLevelCities);
            cities.addAll(thirdLevelCities);
            cities = cities.stream().distinct().sorted(Comparator.comparing(City :: getId)).collect(Collectors.toList());
        } else if (StringUtils.isNotBlank(city.getFirstKeyword())) {
            cities = getActualDao().listByFirstLevelTypeKeywords(city.getFirstKeyword());
            if (CollectionUtils.isEmpty(cities)) {
                return cities;
            }
            cityIds = cities.stream().map(City::getId).collect(Collectors.toSet());
            if (StringUtils.isNotBlank(city.getSecondKeyword())) {
                cities = getActualDao().listBySecondLevelTypeKeywords(cityIds, city.getSecondKeyword());
                cityIds = cities.stream().map(City::getId).collect(Collectors.toSet());
            }
            if (StringUtils.isNotBlank(city.getThirdKeyword())) {
                cities = getActualDao().listByThirdLevelTypeKeywords(cityIds, city.getThirdKeyword());
            }
        }
        return cities;
    }
}