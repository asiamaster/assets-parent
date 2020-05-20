package com.dili.assets.provider;

import com.dili.assets.domain.Booth;
import com.dili.assets.service.BoothService;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BoothPathProvider implements ValueProvider {
    @Autowired
    private BoothService boothService;

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
        Booth booth = boothService.get(Long.parseLong(rowData.get("id").toString()));

        if (booth != null) {
            if (booth.getParentId() == 0) {
                return booth.getName();
            } else {
                Booth parent = boothService.get(booth.getParentId());
                return parent.getName() + "-" + booth.getName();
            }
        }
        return null;
    }
}
