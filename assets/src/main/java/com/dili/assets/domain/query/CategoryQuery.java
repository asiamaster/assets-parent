package com.dili.assets.domain.query;

import com.dili.assets.domain.Category;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

/**
 * 用于构造查询条件的实体
 */
public class CategoryQuery extends Category {


    private Long marketId;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
    // ==========================动态SQL过滤字段==================================== //

    /**
     * 用于快速查找整棵品类树 where path like '1,2,3,%'
     */
    @Like(Like.RIGHT)
    @Column(name = "`path`")
    private String queryPath;

    /**
     * 状态过滤字段 where state <> ?
     */
    @Operator(Operator.NOT_EQUAL)
    @Column(name = "`state`")
    private Integer stateFilter;

    @Like
    @Column(name = "`name`")
    private String likeName;

    @Transient
    private String keyword;

    @Transient
    private String orName;

    @Transient
    private String keycode;

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    @Transient
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

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
