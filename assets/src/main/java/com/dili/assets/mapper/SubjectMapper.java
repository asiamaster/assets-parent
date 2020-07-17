package com.dili.assets.mapper;

import com.dili.assets.domain.Subject;
import com.dili.assets.domain.query.SubjectQuery;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper extends MyMapper<Subject> {

    /**
     * 品类重复检测：名称、编码
     */
    List<Subject> exists(Subject condition);


    /**
     * list
     * @param condition
     * @return
     */
    List<Subject> listSubject(SubjectQuery condition);

    /**
     * 批量更新品类状态信息
     */
    void batchUpdate(@Param("list") List<Long> ids, @Param("value") Integer value);


}