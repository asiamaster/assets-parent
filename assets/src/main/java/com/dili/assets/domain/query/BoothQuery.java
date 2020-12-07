package com.dili.assets.domain.query;

import com.dili.assets.domain.Assets;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @author shaofan
 */
public class BoothQuery extends Assets {


    // ==========================动态SQL过滤字段==================================== //

    /**
     * 用于快速查找整棵品类树 where path like '1,2,3,%'
     */
    @Like()
    @Column(name = "`name`")
    private String keyword;
   @Operator(Operator.GREAT_EQUAL_THAN)
    @Column(name = "`create_time`")
    private Date startTime;
    @Operator(Operator.LITTLE_EQUAL_THAN)
    @Column(name = "`create_time`")
    private Date endTime;
    @Operator(Operator.GREAT_EQUAL_THAN)
    @Column(name = "`number`")
    private Double startNumber;
    @Operator(Operator.LITTLE_EQUAL_THAN)
    @Column(name = "`number`")
    private Double endNumber;
    private String deps;

    @Operator(Operator.IN)
    @Column(name = "`id`")
    private List<String> ids;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Double startNumber) {
        this.startNumber = startNumber;
    }

    public Double getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Double endNumber) {
        this.endNumber = endNumber;
    }

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
    // ==========================动态SQL过滤字段==================================== //
}
