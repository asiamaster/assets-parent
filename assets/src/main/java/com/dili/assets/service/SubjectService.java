package com.dili.assets.service;

import com.dili.assets.domain.Subject;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
public interface SubjectService extends BaseService<Subject, Long> {
    /**
     * 新增品类
     *
     * @param input {@link Subject}
     */
    void save(Subject input);

    /**
     * 修改品类
     *
     * @param input {@link Subject}
     */
    void edit(Subject input);

    /**
     * 批量修改品类状态
     *
     * @param id 主键
     */
    void batchUpdate(Long id, Integer value);

}