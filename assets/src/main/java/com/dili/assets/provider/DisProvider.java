package com.dili.assets.provider;

import com.dili.assets.domain.District;
import com.dili.assets.service.DistrictService;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DisProvider implements ValueProvider {
    @Autowired
    private DistrictService districtService;

    @Override
    public List<ValuePair<?>> getLookupList(Object val, Map metaMap, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDisplayText(Object val, Map metaMap, FieldMeta fieldMeta) {
        if (metaMap == null || metaMap.get("_rowData") == null) {
            return null;
        }
        HashMap rowData = (HashMap) metaMap.get("_rowData");
        if (rowData.get("parentId").toString().equals("0")) {
            return rowData.get("name").toString();
        } else {
            District parent = districtService.get(Long.parseLong(rowData.get("parentId").toString()));
            return parent.getName() + "," + rowData.get("name").toString();
        }
    }
}
