package com.dili.assets.domain.query;

import com.dili.assets.domain.AreaMarket;
import com.dili.ss.domain.annotation.Operator;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class AreaMarketQuery extends AreaMarket {

    @Operator(Operator.IN)
    @Column(name = "`area`")
    private List<Long> ids;
}
