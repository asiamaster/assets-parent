package com.dili.assets.provider;

import cn.hutool.core.collection.CollectionUtil;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.metadata.BatchProviderMeta;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.provider.BatchDisplayTextProviderSupport;
import com.dili.uap.sdk.domain.Department;
import com.dili.uap.sdk.domain.dto.DepartmentDto;
import com.dili.uap.sdk.rpc.DepartmentRpc;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuehongbo
 * @Copyright 本软件源代码版权归农丰时代科技有限公司及其研发团队所有, 未经许可不得任意复制与传播.
 * @date 2021/3/8 11:45
 */
@RequiredArgsConstructor
@Component
@Scope("prototype")
public class DepartmentBatchProvider extends BatchDisplayTextProviderSupport {

    private final DepartmentRpc departmentRpc;

    @Override
    public List<ValuePair<?>> getLookupList(Object obj, Map metaMap, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    protected BatchProviderMeta getBatchProviderMeta(Map metaMap) {
        BatchProviderMeta batchProviderMeta = DTOUtils.newInstance(BatchProviderMeta.class);
        //设置主DTO和关联DTO需要转义的字段名
        batchProviderMeta.setEscapeFiled("value");
        //忽略大小写关联
        batchProviderMeta.setIgnoreCaseToRef(true);
        //关联(数据库)表的主键的字段名，默认取id
        batchProviderMeta.setRelationTablePkField("code");
        //当未匹配到数据时，返回的值
        batchProviderMeta.setMismatchHandler(t -> "-");
        return batchProviderMeta;
    }

    @Override
    protected List getFkList(List<String> relationIds, Map metaMap) {
        //存储请求部门查询数据的id集合
        Set<String> departmentIds = Sets.newHashSet();

        if (CollectionUtil.isNotEmpty(relationIds)) {
            relationIds.stream().forEach(t -> {
                List<String> strings = Arrays.asList(t.split(","));
                departmentIds.addAll(strings);
            });
        }
        if (CollectionUtil.isNotEmpty(departmentIds)) {
            DepartmentDto query = DTOUtils.newInstance(DepartmentDto.class);
            query.setIds(new ArrayList<>(departmentIds));
            List<Department> byIds = departmentRpc.listByExample(query).getData();
            List<Map<String, Object>> resultList = Lists.newArrayList();
            if (CollectionUtil.isNotEmpty(byIds)) {
                for (String relationId : relationIds) {
                    Map<String, Object> data = Maps.newHashMap();
                    String collect = byIds.stream().filter(t -> Sets.newHashSet(Arrays.asList(relationId.split(","))).contains(String.valueOf(t.getId()))).map(Department::getName).collect(Collectors.joining(","));
                    data.put("code", relationId);
                    data.put("value", collect);
                    resultList.add(data);
                }
            }
            return resultList;
        }
        return null;
    }
}
