package com.dili.assets.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dili.assets.domain.Assets;
import com.dili.assets.domain.query.BoothQuery;
import com.dili.assets.sdk.dto.AssetsDTO;
import com.dili.assets.sdk.dto.AssetsPOJO;
import com.dili.assets.service.AssetsService;
import com.dili.commons.glossary.YesOrNoEnum;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-17 13:21:57.
 */
@RestController
@RequestMapping("/api/assets")
public class BoothController {
    @Autowired
    AssetsService boothService;

    @Autowired
    private Javers javers;

    @Autowired
    private AmqpTemplate template;

    /**
     * 新增摊位
     *
     * @param booth
     * @return
     */
    @RequestMapping("save")
    public BaseOutput save(@RequestBody Assets booth) {
        try {
            booth.setCreateTime(new Date());
            booth.setModifyTime(new Date());
            booth.setParentId(0L);
            boothService.saveBooth(booth);
            AssetsPOJO pojo = new AssetsPOJO();
            BeanUtil.copyProperties(booth, pojo);
            javers.commit("assets", pojo);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        }
        return BaseOutput.success();
    }

    /**
     * 搜索摊位
     */
    @RequestMapping("search")
    public BaseOutput<List<AssetsDTO>> search(@RequestBody BoothQuery query) {
        query.setIsDelete(YesOrNoEnum.NO.getCode());
        return BaseOutput.success().setData(boothService.search(query));
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @RequestMapping("get")
    public BaseOutput<Assets> get(@RequestBody Long id) {
        return BaseOutput.success().setData(boothService.get(id));
    }

    /**
     * 新增摊位
     *
     * @param booth
     * @return
     */
    @RequestMapping("update")
    public BaseOutput update(@RequestBody Assets booth) {
        boothService.updateSelective(booth);
        AssetsPOJO pojo = new AssetsPOJO();
        BeanUtil.copyProperties(booth, pojo);
        javers.commit("assets", pojo);
        try {
            template.convertAndSend("exchange", "assets.update", JSONUtil.toJsonStr(pojo));
        } catch (Exception ignored) {
        }
        return BaseOutput.success();
    }

    /**
     * 获取摊位列表
     *
     * @param booth
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestBody BoothQuery booth) {
        return boothService.listForPage(booth);
    }

    /**
     * 获取摊位剩余面积
     */
    @RequestMapping("getBoothBalance")
    public BaseOutput<Double> getBoothBalance(@RequestBody Long id) {
        return BaseOutput.success().setData(boothService.getBoothBalance(id));
    }

    /**
     * 删除摊位
     */
    @RequestMapping("delete")
    public BaseOutput delete(@RequestBody Long id) {
        try {
            boothService.deleteBooth(id);
            try {
                template.convertAndSend("exchange", "assets.delete", id);
            } catch (Exception ignored) {
            }
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        }
        return BaseOutput.success();
    }

    /**
     * 摊位拆分
     */
    @RequestMapping(value = "/split", method = RequestMethod.POST)
    public BaseOutput boothSplit(Long parentId, String[] names, String notes, String[] numbers) {
        try {
            boothService.boothSplit(parentId, names, notes, numbers);
        } catch (BusinessException be) {
            return BaseOutput.failure(be.getMessage());
        }
        return BaseOutput.success();
    }

    /**
     * 快照
     */
    @RequestMapping(value = "/snapshots", method = RequestMethod.POST)
    public BaseOutput snapshots(@RequestBody Long id) {
        JqlQuery query = QueryBuilder.byInstanceId(id, AssetsPOJO.class).build();
        JSONArray array = new JSONArray();
        List<CdoSnapshot> snapshots = javers.findSnapshots(query);
        snapshots.forEach(it -> {
            JSONObject object = new JSONObject();
            object.put("version", it.getVersion());
            object.put("commitDate", LocalDateTimeUtil.format(it.getCommitMetadata().getCommitDate(), DatePattern.NORM_DATETIME_PATTERN));
            object.put("notes", it.getCommitMetadata().getProperties().get("notes"));
            JSONObject jsonObject = new JSONObject();
            it.getState().forEachProperty((pName, pValue) -> jsonObject.put(pName, pValue));
            object.put("state", jsonObject);
            array.add(object);
        });
        return BaseOutput.success().setData(array);
    }

}