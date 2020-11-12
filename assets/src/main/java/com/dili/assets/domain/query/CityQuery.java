package com.dili.assets.domain.query;

import com.dili.assets.domain.City;
import com.dili.ss.domain.annotation.Like;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;
import java.util.List;

/**
 * 城市信息查询
 * @author yuehongbo
 * @Copyright 本软件源代码版权归农丰时代科技有限公司及其研发团队所有, 未经许可不得任意复制与传播.
 * @date 2020/8/1 17:44
 */
public class CityQuery extends City {

    /**
     * 根据ID集合查询
     */
    @Column(name = "`id`")
    @Operator(Operator.IN)
    private List<Long> idList;

    /**
     * 级别集合查询
     */
    @Column(name = "`level_type`")
    @Operator(Operator.IN)
    private List<Integer> levelTypeList;

    @Column(name = "`name`")
    @Like
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Long> getIdList() {
        return idList;
    }
    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
    public List<Integer> getLevelTypeList() {
        return levelTypeList;
    }
    public void setLevelTypeList(List<Integer> levelTypeList) {
        this.levelTypeList = levelTypeList;
    }
}
