package com.dili.assets.mapper;

import com.dili.assets.domain.City;
import com.dili.assets.sdk.dto.CityKeyWordsQueryDto;
import com.dili.ss.base.MyMapper;

import java.util.List;
import java.util.Set;

public interface CityMapper extends MyMapper<City> {

    List<City> listByFirstLevelTypeKeywords(String firstKeyword);

    List<City> listBySecondLevelTypeKeywords(Set<Long> cityIds, String secondKeyword);

    List<City> listByThirdLevelTypeKeywords(Set<Long> cityIds, String thirdKeyword);

    List<City> listByAllLevelTypeKeywords(String allLevelKeyword);

    List<City>  listByParentIds(Set<Long> firstLevelCityIds);
}