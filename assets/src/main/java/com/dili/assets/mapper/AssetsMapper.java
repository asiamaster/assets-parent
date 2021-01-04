package com.dili.assets.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.dili.assets.domain.Assets;
import com.dili.ss.base.MyMapper;

public interface AssetsMapper extends MyMapper<Assets> {
    int updateStateByIdIn(@Param("idList") Collection<Long> idList);
}