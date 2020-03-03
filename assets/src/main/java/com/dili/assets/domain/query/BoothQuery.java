package com.dili.assets.domain.query;

import com.dili.assets.domain.Booth;
import com.dili.ss.domain.annotation.Like;

import javax.persistence.Column;

/**
 * @author shaofan
 */
public class BoothQuery extends Booth {


    // ==========================动态SQL过滤字段==================================== //

    /**
     * 用于快速查找整棵品类树 where path like '1,2,3,%'
     */
    @Like(Like.BOTH)
    @Column(name = "`name`")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // ==========================动态SQL过滤字段==================================== //
}
