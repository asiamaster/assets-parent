package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.query.CategoryQuery;
import com.dili.assets.mapper.CategoryMapper;
import com.dili.assets.service.CategoryService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {

    public CategoryMapper getActualDao() {
        return (CategoryMapper) getDao();
    }

    @Override
    @Transactional
    public void saveCategory(Category c) {
        if (c.getParent() != null) {
            Category p = this.get(c.getParent());
            if (p == null) {
                throw new BusinessException("1", "父品类不存在");
            }
            if (p.getState().equals(3)) {
                throw new BusinessException("1", "父品类已删除");
            }
            c.setPath(p.getPath());
        } else {
            c.setParent(0L);
        }

//        if (nameExists(c)) {
//            throw new BusinessException("1", "品类名称有重复,请重新输入");
//        }
        if (codeExists(c)) {
            throw new BusinessException("1", "品类代码有重复,请重新输入");
        }
        c.setState(1);
        getActualDao().insert(c);
        if (c.getParent() == 0L) {
            c.setPath(c.getId().toString() + ",");
        } else {
            c.setPath(c.getPath() + c.getId() + ",");
        }
        if (StrUtil.isNotBlank(c.getPath())) {
            c.setCateLevel(c.getPath().split(",").length);
        }
        getActualDao().updateByPrimaryKey(c);
    }

    @Override
    public void updateCategory(Category input) {
        Category temp = getActualDao().selectByPrimaryKey(input.getId());
        if (temp == null) {
            throw new BusinessException("1", "要修改的品类不存在!");
        }
        if (temp.getState().equals(3)) {
            throw new BusinessException("1", "要修改的品类已删除!");
        }
//        if (nameExists(input)) {
//            throw new BusinessException("1", "品类名称有重复,请重新输入");
//        }
        if (codeExists(input)) {
            throw new BusinessException("1", "品类代码有重复,请重新输入");
        }
        getActualDao().updateByPrimaryKeySelective(input);
    }

    @Override
    public void batchUpdate(Long id, Integer value) {
        List<Long> ids = new ArrayList<>();
        Category parent = get(id);
        CategoryQuery condition = new CategoryQuery();
        condition.setQueryPath(parent.getPath());
        List<Category> byExample = this.listByExample(condition);
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

    private boolean nameExists(Category c) {
        Category condition = new Category();
        condition.setName(c.getName());
        //condition.setParent(c.getParent());
        List<Category> list = getActualDao().exists(condition);
        if (list == null || list.size() == 0) {
            return false;
        }
        if (c.getId() == null) {
            return true;
        }
        for (Category t : list) {
            if (!c.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean codeExists(Category c) {
        if (c.getCode() == null || "".equals(c.getCode().trim())) {
            return false;
        }
        Category condition = new Category();
        condition.setCode(c.getCode());
        //condition.setParent(c.getParent());
        List<Category> list = getActualDao().exists(condition);
        if (list == null || list.size() == 0) {
            return false;
        }
        if (c.getId() == null) {
            return true;
        }
        for (Category t : list) {
            if (!c.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }
}