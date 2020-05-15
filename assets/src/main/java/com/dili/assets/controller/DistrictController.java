package com.dili.assets.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dili.assets.domain.District;
import com.dili.assets.domain.query.DistrictQuery;
import com.dili.assets.glossary.StateEnum;
import com.dili.assets.service.DistrictService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.dto.IDTO;
import com.dili.ss.exception.BusinessException;
import com.dili.ss.metadata.ValueProviderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 11:17:18.
 */
@RestController
@RequestMapping("/api/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    /**
     * 新增区域
     */
    @RequestMapping("save")
    public BaseOutput save(@RequestBody District input) {
        try {
            districtService.saveDistrict(input);
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        }
        return BaseOutput.success();
    }

    /**
     * 新增区域
     */
    @RequestMapping("edit")
    public BaseOutput edit(@RequestBody District input) {
        try {
            districtService.editDistrict(input);
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        }
        return BaseOutput.success();
    }

    /**
     * 获取单个区域
     */
    @RequestMapping("get")
    public BaseOutput<District> get(@RequestBody Long id) {
        District district = districtService.get(id);
        return BaseOutput.success().setData(district);
    }

    /**
     * 删除区域
     */
    @RequestMapping("delete")
    public BaseOutput<District> delete(@RequestBody Long id) {
        try {
            districtService.delDistrict(id);
            return BaseOutput.success();
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure(e.getMessage());
        }
    }

    /**
     * 获取区域列表
     *
     * @param input
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestBody DistrictQuery input) {
        try {
            if (input != null && input.getIsDelete() == null) {
                input.setIsDelete(StateEnum.NO.getCode());
            }
            if (input.getDepartmentId() == null && StrUtil.isNotBlank(input.getDeps())) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "(department_id in (" + input.getDeps() + ") or department_id is null)");
            }

            if (input.getDepartmentId() == null && StrUtil.isBlank(input.getDeps())) {
                input.setMetadata(IDTO.AND_CONDITION_EXPR, "department_id is null");
            }
            input.setDeps(null);
            int count = 0;
            if (input.getId() == null) {
                count = districtService.listByExample(input).size();
                input.setParentId(0L);
            } else {
                input.setParentId(input.getId());
                input.setId(null);
            }

            List<District> districts = districtService.listByExample(input);
            List result = new ArrayList();

            for (District district : districts) {
                JSONObject json = JSON.parseObject(JSON.toJSONString(district));
                json.put("state", "closed");
                result.add(json);
            }
            String resultJsonStr = JSONObject.toJSONString(result);
            if (count == 0) {
                return resultJsonStr;
            }
            JSONObject obj = new JSONObject();
            obj.put("rows", JSON.parseArray(resultJsonStr));
            obj.put("footer", JSON.parseArray("[\n" +
                    "\t{\"name\":\"总数:\",\"number\":" + count + ",\"iconCls\":\"icon-sum\"}\n" +
                    "]"));
            return obj.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 区域搜索
     */
    @RequestMapping("search")
    public BaseOutput<List<District>> search(@RequestBody District input) {
        try {
            if (input != null && input.getIsDelete() == null) {
                input.setIsDelete(StateEnum.NO.getCode());
            }
            return BaseOutput.success().setData(districtService.listByExample(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseOutput.success();
    }

    /**
     * 区域拆分
     *
     * @param parentId
     * @param names
     * @param notes
     * @param numbers
     * @return
     */
    @RequestMapping(value = "/divisionSave", method = RequestMethod.POST)
    public BaseOutput divisionSave(Long parentId, String[] names, String[] notes, String[] numbers) {
        try {
            districtService.division(parentId, names, notes, numbers);
            return BaseOutput.success();
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure(e.getMessage());
        }
    }
}