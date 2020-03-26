package com.dili.assets.provider;

import com.dili.assets.domain.District;
import com.dili.assets.service.DistrictService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import com.dili.uap.sdk.domain.Department;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DistrictProvider implements ValueProvider {
    @Autowired
    private DistrictService districtService;

    @Override
    public List<ValuePair<?>> getLookupList(Object val, Map metaMap, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDisplayText(Object val, Map metaMap, FieldMeta fieldMeta) {
        if (val == null) {
            return null;
        }
        District district = districtService.get(Long.parseLong(val.toString()));
        if (district != null) {
            return district.getName();
        }
        return null;
    }
}
