package com.dili.assets.domain.query;

import com.dili.assets.domain.District;
import com.dili.ss.domain.annotation.Operator;

import javax.persistence.Column;

public class DistrictQuery extends District {

    private String deps;

    public String getDeps() {
        return deps;
    }

    public void setDeps(String deps) {
        this.deps = deps;
    }
}
