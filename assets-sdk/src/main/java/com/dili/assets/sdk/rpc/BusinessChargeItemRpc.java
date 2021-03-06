package com.dili.assets.sdk.rpc;

import com.dili.assets.sdk.dto.BusinessChargeItemDto;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.PageOutput;
import com.dili.ss.retrofitful.annotation.POST;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <B></B>
 * <B>Copyright:本软件源代码版权归农丰时代科技有限公司及其研发团队所有,未经许可不得任意复制与传播.</B>
 * <B>农丰时代科技有限公司</B>
 *
 * @author yuehongbo
 * @date 2020/6/5 16:03
 */
@FeignClient(name = "assets-service", contextId = "businessChargeItemRpc",url = "${AssetsRpc.url:}")
public interface BusinessChargeItemRpc {

    /**
     * 获取业务收费项列表信息
     * @param businessChargeItemDto
     */
    @PostMapping(value = "/api/businessChargeItem/listPage")
    PageOutput<List<BusinessChargeItemDto>> listPage(BusinessChargeItemDto businessChargeItemDto);

    /**
     * 获取业务收费项列表信息
     * @param businessChargeItemDto
     */
    @PostMapping(value = "/api/businessChargeItem/listByExample")
    BaseOutput<List<BusinessChargeItemDto>> listByExample(BusinessChargeItemDto businessChargeItemDto);

    /**
     * 获取单个收费项信息
     * @param id 收费项ID
     * @return
     */
    @PostMapping(value = "/api/businessChargeItem/getById")
    BaseOutput<BusinessChargeItemDto> getById(@RequestParam("id") Long id);

    /**
     * 保存收费项信息
     * @param businessChargeItemDto
     * @return
     */
    @PostMapping(value = "/api/businessChargeItem/save")
    BaseOutput save(BusinessChargeItemDto businessChargeItemDto);

}