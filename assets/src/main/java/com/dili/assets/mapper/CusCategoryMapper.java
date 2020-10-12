package com.dili.assets.mapper;

import com.dili.assets.domain.Category;
import com.dili.assets.domain.CusCategory;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.sdk.dto.CusCategoryQuery;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CusCategoryMapper extends MyMapper<CusCategory> {

    /**
     * 品类重复检测：名称、编码
     */
    List<CusCategory> exists(CusCategory condition);

    /**
     * list
     * @param condition
     * @return
     */
    List<CusCategory> listCategory(CusCategoryQuery condition);


    /**
     * 批量更新品类状态信息
     */
    void batchUpdate(@Param("list") List<Long> ids, @Param("value") Integer value);


}