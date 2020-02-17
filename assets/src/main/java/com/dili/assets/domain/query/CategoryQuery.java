package com.dili.assets.domain.query;

import com.dili.assets.domain.Category;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;

/**
 * 用于构造查询条件的实体
 */
public class CategoryQuery extends Category {

    // ==========================动态SQL过滤字段==================================== //

    /**
     * 用于快速查找整棵品类树 where path like '1,2,3,%'
     */
    @Like(Like.LEFT)
    @Column(name = "`path`")
    private String queryPath;

    /**
     * 状态过滤字段 where state <> ?
     */
    @Operator(Operator.NOT_EQUAL)
    @Column(name = "`state`")
    private Integer stateFilter;

    public String getQueryPath() {
        return queryPath;
    }

    public void setQueryPath(String queryPath) {
        this.queryPath = queryPath;
    }

    public Integer getStateFilter() {
        return stateFilter;
    }

    public void setStateFilter(Integer stateFilter) {
        this.stateFilter = stateFilter;
    }

    // ==========================动态SQL过滤字段==================================== //
}
