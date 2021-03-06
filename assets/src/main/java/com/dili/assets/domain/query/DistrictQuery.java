package com.dili.assets.domain.query;

import com.dili.assets.domain.District;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

public class DistrictQuery extends District {

    @Operator(Operator.IN)
    @Column(name = "`id`")
    private List<String> ids;

    private String deps;

    public String getDeps() {
        return deps;
    }

    public void setDeps(String deps) {
        this.deps = deps;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Like
    @Column(name = "`name`")
    private String nameLike;

    /**
     * 商户
     */
    @Transient
    private Long mchId;

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }
}
