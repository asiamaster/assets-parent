package com.dili.assets.provider;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.Booth;
import com.dili.assets.service.impl.BoothServiceImpl;
import com.dili.commons.glossary.EnabledStateEnum;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValuePairImpl;
import com.dili.ss.metadata.ValueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <B>Description</B>
 * 本软件源代码版权归农丰时代及其团队所有,未经许可不得任意复制与传播
 * <B>农丰时代科技有限公司</B>
 *
 * @author qinkelan
 * @createTime 2020-02-11 17:38
 */
@Component
public class BoothStateProvider implements ValueProvider {
    private static final List<ValuePair<?>> BUFFER = new ArrayList<>();

    @Autowired
    private BoothServiceImpl boothService;

    static {
        BUFFER.addAll(Stream.of(EnabledStateEnum.values())
                .map(e -> new ValuePairImpl<>(e.getName(), e.getCode().toString()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<ValuePair<?>> getLookupList(Object o, Map map, FieldMeta fieldMeta) {
        return BUFFER;
    }

    @Override
    public String getDisplayText(Object object, Map map, FieldMeta fieldMeta) {
        if (null == object) {
            return null;
        }
        Map rowData = (Map) map.get("_rowData");
        Long id = (Long) rowData.get("id");
        Booth query = new Booth();
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        query.setParentId(id);
        if (CollUtil.isNotEmpty(boothService.listByExample(query))) {
            return null;
        }
        for (ValuePair<?> valuePair : BUFFER) {
            if (valuePair.getValue().equals(object.toString())) {
                return valuePair.getText();
            }
        }

        return null;
    }
}
