package com.dili.assets.sdk.rpc;

import com.dili.assets.sdk.dto.BusinessChargeItemDto;
import com.dili.assets.sdk.dto.CityDto;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 城市信息接口
 * @author yuehongbo
 * @Copyright 本软件源代码版权归农丰时代科技有限公司及其研发团队所有, 未经许可不得任意复制与传播.
 * @date 2020/7/14 16:00
 */
@FeignClient(name = "assets-service", contextId = "cityRpc", url = "${AssetsRpc.url:}")
public interface CityRpc {

    /**
     * 获取城市信息列表
     * @param cityDto
     */
    @RequestMapping(value = "/api/city/listByExample", method = RequestMethod.POST)
    BaseOutput<List<CityDto>> listByExample(CityDto cityDto);

    /**
     * 获取城市信息列表
     * @param cityDto
     */
    @RequestMapping(value = "/api/city/list", method = RequestMethod.POST)
    BaseOutput<List<CityDto>> list(CityDto cityDto);
}
