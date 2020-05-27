package com.dili.assets.provider;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;

@Component
public class CarTypeClassifyProvider implements ValueProvider {
	
    @Autowired
    DataDictionaryRpc dataDictionaryRpc;
    
    @Override
    public List<ValuePair<?>> getLookupList(Object val, Map metaMap, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDisplayText(Object val, Map metaMap, FieldMeta fieldMeta) {
        if (val == null) {
            return null;
        }
        List<DataDictionaryValue> list = dataDictionaryRpc.listDataDictionaryValueByDdCode("cartype_classify").getData();

        for (int i = 0; i < list.size(); i++) {
            DataDictionaryValue dataDictionaryValue = list.get(i);
        	if (dataDictionaryValue.getCode().equals(val.toString())) {
        		return dataDictionaryValue.getName();
        	}
        }
        return null;
    }
}
