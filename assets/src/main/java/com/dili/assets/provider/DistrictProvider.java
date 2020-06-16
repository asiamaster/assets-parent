package com.dili.assets.provider;

import com.dili.assets.domain.query.DistrictQuery;
import com.dili.assets.service.DistrictService;
import com.dili.ss.metadata.provider.BatchDisplayTextProviderAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域提供者
 */
@Component
public class DistrictProvider extends BatchDisplayTextProviderAdaptor {
    @Autowired
    private DistrictService districtService;


    @Override
    protected List getFkList(List<String> relationIds, Map metaMap) {
        DistrictQuery query = new DistrictQuery();
        query.setIds(relationIds);
        return districtService.listByExample(query);
    }

    @Override
    protected Map<String, String> getEscapeFileds(Map metaMap) {
        if (metaMap.get(ESCAPE_FILEDS_KEY) instanceof Map) {
            return (Map) metaMap.get(ESCAPE_FILEDS_KEY);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put(metaMap.get(FIELD_KEY).toString(), "name");
            return map;
        }
    }
}
