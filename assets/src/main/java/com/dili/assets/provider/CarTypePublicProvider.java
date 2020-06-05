package com.dili.assets.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dili.ss.dto.DTOUtils;
import com.dili.ss.metadata.FieldMeta;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValueProvider;
import com.dili.uap.sdk.domain.DataDictionaryValue;
import com.dili.uap.sdk.domain.UserTicket;
import com.dili.uap.sdk.rpc.DataDictionaryRpc;
import com.dili.uap.sdk.session.SessionContext;

public class CarTypePublicProvider implements ValueProvider {
	
	@Autowired
    private DataDictionaryRpc dataDictionaryRpc;

	@Override
	public List<ValuePair<?>> getLookupList(Object val, Map metaMap, FieldMeta fieldMeta) {
        return null;
	}

	@Override
	public String getDisplayText(Object val, Map metaMap, FieldMeta fieldMeta) {
		try {
			if (val == null) {
	            return null;
	        }
			UserTicket userTicket = SessionContext.getSessionContext().getUserTicket();
	    	DataDictionaryValue dataDictionaryValue = DTOUtils.newInstance(DataDictionaryValue.class);
	    	dataDictionaryValue.setDdCode("cartype_tag");
	    	dataDictionaryValue.setFirmId(userTicket.getFirmId());
	    	
	    	List<DataDictionaryValue> list = dataDictionaryRpc.listDataDictionaryValue(dataDictionaryValue).getData();
	    	List<String> displayText = new ArrayList<String>();
	    	String[] tags = val.toString().split(",");
	    	for (int i = 0; i < tags.length; i++) {
	    		for (int j = 0; j < list.size(); j++) {
	    			DataDictionaryValue data = list.get(j);
	    			if (data.getCode().equals(tags[i])) {
	    				displayText.add(dataDictionaryValue.getName());
	    			}
	    		}
			}
	    	return StringUtils.join(displayText, ',');
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
