package com.dili.assets.provider;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import com.dili.uap.sdk.domain.Department;
import com.dili.uap.sdk.domain.dto.DepartmentDto;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if(StrUtil.isBlank(val.toString())){
            return null;
        }
        DepartmentDto query = DTOUtils.newInstance(DepartmentDto.class);
        query.setIds(StrUtil.split(val.toString(), ','));
        List<Department> departmentList = departmentRpc.listByExample(query).getData();
        if (CollUtil.isNotEmpty(departmentList)) {
            return departmentList.stream().map(it -> it.getName()).collect(Collectors.joining(","));
        }
        return null;
    }
}
