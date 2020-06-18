package com.dili.assets.mapper;

import com.dili.assets.domain.CustomCategory;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomCategoryMapper extends MyMapper<CustomCategory> {
    void batchUpdateCustomCategory(@Param("value") Integer value, @Param("list") List<Long> ids);
}