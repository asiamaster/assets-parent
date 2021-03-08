package com.dili.assets.provider;

import com.dili.ss.dto.DTOUtils;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class CarTypePublicTagProvider implements ValueProvider {
	@Autowired
    private DataDictionaryRpc dataDictionaryRpc;

    @Override
    public List<ValuePair<?>> getLookupList(Object o, Map map, FieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDisplayText(Object val, Map map, FieldMeta fieldMeta) {
    	if (val == null) {
            return null;
        }
    	Map<String, Object> _rowData = (Map<String, Object>) map.get("_rowData");
    	DataDictionaryValue dataDictionaryValue = DTOUtils.newInstance(DataDictionaryValue.class);
    	dataDictionaryValue.setDdCode("cartype_tag");
    	dataDictionaryValue.setFirmId(Long.valueOf(_rowData.get("market_id").toString()));
    	List<DataDictionaryValue> list = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue).getData();
    	List<String> displayText = new ArrayList<String>();
    	String[] tags = val.toString().split(",");
    	for (int i = 0; i < tags.length; i++) {
    		for (int j = 0; j < list.size(); j++) {
    			DataDictionaryValue data = list.get(j);
    			if (data.getCode().equals(tags[i])) {
    				displayText.add(data.getName());
    			}
    		}
		}
        return StringUtils.join(displayText, ',');
    }
}
