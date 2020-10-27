package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.Subject;
import com.dili.assets.domain.query.SubjectQuery;
import com.dili.assets.mapper.SubjectMapper;
import com.dili.assets.service.SubjectService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject, Long> implements SubjectService {

    public SubjectMapper getActualDao() {
        return (SubjectMapper) getDao();
    }

    @Override
    public void save(Subject c) {
        if (c.getParent() != null) {
            Subject p = this.get(c.getParent());
            if (p == null) {
                throw new BusinessException("1", "父科目不存在");
            }
            if (p.getState().equals(3)) {
                throw new BusinessException("1", "父科目已删除");
            }
            c.setPath(p.getPath());
        } else {
            c.setParent(0L);
        }

        if (nameExists(c)) {
            throw new BusinessException("1", "科目名称有重复,请重新输入");
        }
        c.setState(1);
        getActualDao().insert(c);
        if (c.getParent() == 0L) {
            c.setPath(c.getId().toString() + ",");
        } else {
            c.setPath(c.getPath() + c.getId() + ",");
        }
        getActualDao().updateByPrimaryKey(c);
    }

    @Override
    public void edit(Subject input) {
        Subject temp = getActualDao().selectByPrimaryKey(input.getId());
        if (temp == null) {
            throw new BusinessException("1", "要修改的科目不存在!");
        }
        if (temp.getState().equals(3)) {
            throw new BusinessException("1", "要修改的科目已删除!");
        }
        if (nameExists(input)) {
            throw new BusinessException("1", "科目名称有重复,请重新输入");
        }
        getActualDao().updateByPrimaryKeySelective(input);
    }

    @Override
    public void batchUpdate(Long id, Integer value) {
        List<Long> ids = new ArrayList<>();
        Subject parent = get(id);
        SubjectQuery condition = new SubjectQuery();
        condition.setQueryPath(parent.getPath());
        List<Subject> byExample = this.listByExample(condition);
        if (CollUtil.isNotEmpty(byExample)) {
            byExample.forEach(category -> ids.add(category.getId()));
        } else {
            ids.add(id);
        }
        getActualDao().batchUpdate(ids, value);
    }

    /**
     * 验证添加层级是否大于3级，由于没有level字段，只有根据父品类path字段来判断
     *
     * @return
     */
    private boolean checkLevel(Category p) {
        if (p == null) {
            return true;
        }
        if (p.getPath() == null) {
            return true;
        }
        return p.getPath().split(",").length < 3;
    }

    private boolean nameExists(Subject c) {
        Subject condition = new Subject();
        condition.setName(c.getName());
        //condition.setParent(c.getParent());
        List<Subject> list = getActualDao().exists(condition);
        if (list == null || list.size() == 0) {
            return false;
        }
        if (c.getId() == null) {
            return true;
        }
        for (Subject t : list) {
            if (!c.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }

}