package com.dili.assets.mapper;

import com.dili.assets.domain.CustomCategory;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.sdk.dto.CategoryDTO;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomCategoryMapper extends MyMapper<CustomCategory> {
    void batchUpdateCustomCategory(@Param("value") Integer value, @Param("list") List<Long> ids);
    /**
     * list
     * @param condition
     * @return
     */
    List<CategoryDTO> listCategory(CategoryQuery condition);

    /**
     * list
     * @param condition
     * @return
     */
    List<CategoryDTO> listCusCategory(CategoryQuery condition);


}