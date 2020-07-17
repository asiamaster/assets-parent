package com.dili.assets.controller;

import com.dili.assets.domain.Subject;
import com.dili.assets.domain.query.SubjectQuery;
import com.dili.assets.mapper.SubjectMapper;
import com.dili.assets.service.SubjectService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectMapper subjectMapper;

    /**
     * 获取品类列表
     */
    @RequestMapping(value = "/getTree")
    public BaseOutput<List<Subject>> getTree(@RequestBody(required = false) SubjectQuery input) {
        List<Subject> list = subjectMapper.listSubject(input);
        return BaseOutput.success().setData(list);
    }

    /**
     * 获取单个品类
     */
    @RequestMapping(value = "/get")
    public BaseOutput<Subject> get(@RequestBody Long id) {
        Subject subject = subjectService.get(id);
        return BaseOutput.success().setData(subject);
    }

    /**
     * 新增品类
     */
    @RequestMapping(value = "/save")
    public BaseOutput save(@RequestBody Subject input) {
        try {
            if (input.getId() != null) {
                subjectService.edit(input);
            } else {
                subjectService.save(input);
            }
        } catch (BusinessException e) {
            return BaseOutput.failure(e.getErrorMsg());
        } catch (Exception e) {
            return BaseOutput.failure("保存失败");
        }
        return BaseOutput.success().setData(subjectService.get(input.getId()));
    }

    /**
     * 删除品类
     */
    @RequestMapping(value = "/batchUpdate")
    public BaseOutput batchUpdate(@RequestParam("id") Long id, @RequestParam("value") Integer value) {
        subjectService.batchUpdate(id, value);
        return BaseOutput.success();
    }
}