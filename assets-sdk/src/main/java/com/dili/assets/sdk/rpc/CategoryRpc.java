package com.dili.assets.sdk.rpc;

import com.dili.assets.sdk.dto.CategoryDTO;
import com.dili.ss.domain.BaseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 品类信息微服务接口
 * @author yuehongbo
 * @Copyright 本软件源代码版权归农丰时代科技有限公司及其研发团队所有, 未经许可不得任意复制与传播.
 * @date 2020/7/17 9:55
 */
@FeignClient(name = "assets-service", contextId = "categoryRpc")
public interface CategoryRpc {

    /**
     * 获取品类信息
     * @param categoryDTO
     * @return
     */
    @RequestMapping(value = "/api/category/getTree", method = RequestMethod.POST)
    BaseOutput<List<CategoryDTO>> getTree(CategoryDTO categoryDTO);
}
