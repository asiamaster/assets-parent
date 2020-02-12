package com.dili.assets.mapper;

import com.dili.assets.domain.Category;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    /**
     * 品类重复检测：名称、编码
     */
    List<Category> exists(Category condition);

    /**
     * 批量更新品类状态信息
     */
    void batchUpdate(@Param("list") List<Long> ids, @Param("value") Integer value);
}