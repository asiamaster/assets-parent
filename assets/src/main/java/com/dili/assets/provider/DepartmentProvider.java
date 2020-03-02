package com.dili.assets.provider;

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
public class DepartmentProvider implements ValueProvider {
    @Autowired
    private DepartmentRpc departmentRpc;

    @Override
    public List<ValuePair<?>> getLookupList(Object val, Map metaMap, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDisplayText(Object val, Map metaMap, FieldMeta fieldMeta) {
        if (val == null) {
            return null;
        }
        BaseOutput<Department> output = departmentRpc.get(Long.parseLong(val.toString()));
        if (output.isSuccess()) {
            return output.getData().getName();
        }
        return null;
    }
}
