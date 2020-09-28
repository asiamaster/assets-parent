package com.dili.assets.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dili.assets.domain.Category;
import com.dili.assets.domain.CusCategory;
import com.dili.assets.mapper.CusCategoryMapper;
import com.dili.assets.mapper.dynamic.CusCategoryDOMapper;
import com.dili.assets.mapper.dynamic.CusCategoryTable;
import com.dili.assets.sdk.dto.CusCategoryQuery;
import com.dili.assets.service.CusCategoryService;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.dili.assets.mapper.dynamic.CusCategoryTable.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-02-05 12:37:16.
 */
@Service
public class CusCategoryServiceImpl extends BaseServiceImpl<CusCategory, Long> implements CusCategoryService {

    public CusCategoryMapper getActualDao() {
        return (CusCategoryMapper) getDao();
    }

    @Autowired
    private CusCategoryDOMapper cusCategoryDOMapper;

    @Override
    @Transactional
    public void saveCategory(CusCategory c) {
        if (c.getParent() != null && c.getParent() != 0L) {
            CusCategory p = this.get(c.getParent());
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
//            throw new BusinessException("1", c.getName() + "名称有重复,请重新输入");
//        }
        if (codeExists(c)) {
            throw new BusinessException("1", c.getKeycode() + "快捷编码有重复,请重新输入");
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
    @Transactional
    public void updateCategory(CusCategory input) {
        CusCategory temp = getActualDao().selectByPrimaryKey(input.getId());
        if (temp == null) {
            throw new BusinessException("1", "要修改的品类不存在!");
        }
        if (temp.getState().equals(3)) {
            throw new BusinessException("1", "要修改的品类已删除!");
        }
//        if (nameExists(input)) {
//            throw new BusinessException("1", input.getName() + "名称有重复,请重新输入");
//        }
        if (codeExists(input)) {
            throw new BusinessException("1", input.getKeycode() + "快捷编码有重复,请重新输入");
        }

        if (!temp.getParent().equals(input.getParent())) {
            CusCategory p = this.get(input.getParent());
            if (p == null) {
                throw new BusinessException("1", "父品类不存在");
            }
            String oldPath = input.getPath();
            input.setPath(p.getPath() + input.getId() + ",");
            cusCategoryDOMapper.update(c -> c.set(path).equalToConstant("REPLACE(path, '" + oldPath + "', '" + input.getPath() + "')"));
        }

        getActualDao().updateByPrimaryKeySelective(input);


    }

    @Override
    public void batchUpdate(Long id, Integer value) {
        List<Long> ids = new ArrayList<>();
        CusCategory parent = get(id);
        CusCategoryQuery condition = new CusCategoryQuery();
        condition.setQueryPath(parent.getPath());
        List<CusCategory> byExample = this.getActualDao().listCategory(condition);
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

    private boolean nameExists(CusCategory c) {
        CusCategory condition = new CusCategory();
        condition.setName(c.getName());
        condition.setMarketId(c.getMarketId());
        //condition.setParent(c.getParent());
        List<CusCategory> list = getActualDao().exists(condition);
        if (list == null || list.size() == 0) {
            return false;
        }
        if (c.getId() == null) {
            return true;
        }
        for (CusCategory t : list) {
            if (!c.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean codeExists(CusCategory c) {
        if (c.getKeycode() == null || "".equals(c.getKeycode().trim())) {
            return false;
        }
        CusCategory condition = new CusCategory();
        condition.setKeycode(c.getKeycode());
        condition.setMarketId(c.getMarketId());
        //condition.setParent(c.getParent());
        List<CusCategory> list = getActualDao().exists(condition);
        if (list == null || list.size() == 0) {
            return false;
        }
        if (c.getId() == null) {
            return true;
        }
        for (CusCategory t : list) {
            if (!c.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }
}