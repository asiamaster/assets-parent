package com.dili.assets.sdk.rpc;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dili.assets.sdk.dto.CarTypeForBusinessDTO;
import com.dili.assets.sdk.dto.TagExtDTO;
import com.dili.ss.domain.BaseOutput;

@FeignClient(name = "assets-service", contextId = "carTypeRpc" /* , url = "http://127.0.0.1:8182" */ )
public interface CarTypeRpc {

    /**
     * 获取默认车型的重量
     */
    @RequestMapping(value = "/api/tagExt/get", method = RequestMethod.POST)
    BaseOutput<TagExtDTO> getWeight(TagExtDTO input);

    /**
     * 获取车型
     */
    @RequestMapping(value = "/api/carTypePublic/listCarTypePublicByBusiness", method = RequestMethod.POST)
	BaseOutput<List<CarTypeForBusinessDTO>> listCarTypePublicByBusiness(CarTypeForBusinessDTO c);


    /**
     * 获取车型（不包含标签内容）
     */
    @RequestMapping(value = "/api/carTypePublic/queryCarType", method = RequestMethod.POST)
    BaseOutput<List<CarTypeForBusinessDTO>> queryCarType(CarTypeForBusinessDTO carTypePublicDTO);
}
