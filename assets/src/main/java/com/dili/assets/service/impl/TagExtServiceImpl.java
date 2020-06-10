package com.dili.assets.service.impl;

import com.dili.assets.domain.TagExt;
import com.dili.assets.mapper.TagExtMapper;
import com.dili.assets.service.TagExtService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2020-05-22 09:17:48.
 */
@Service
public class TagExtServiceImpl extends BaseServiceImpl<TagExt, Long> implements TagExtService {

    public TagExtMapper getActualDao() {
        return (TagExtMapper)getDao();
    }
}