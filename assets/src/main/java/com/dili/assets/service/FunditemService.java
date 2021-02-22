/*
*  Copyright 2019-2020 ShaoFan
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package com.dili.assets.service;

import com.dili.assets.domain.Funditem;
import com.dili.assets.sdk.dto.FunditemQuery;
import com.dili.ss.domain.BaseOutput;
import com.github.pagehelper.PageInfo;
import com.dili.ss.base.BaseService;
import java.util.List;

/**
* @website http://shaofan.org
* @description 服务接口
* @author shaofan
* @date 2021-02-22
**/
public interface FunditemService extends BaseService<Funditem, Long> {

    /**
    * 查询数据分页
    * @param query 条件
    * @return PageInfo<Funditem>
    */
    PageInfo<Funditem> query(FunditemQuery query);

    /**
    * 查询所有数据
    * @param query 条件
    */
    BaseOutput<List<Funditem>> queryAll(FunditemQuery query);


    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 多选启用
    * @param ids /
    */
    void enableAll(Long[] ids);

    /**
    * 多选禁用
    * @param ids /
    */
    void disableAll(Long[] ids);

    /**
    *  新增
    * @param funditem
    * @return
    */
    BaseOutput saveFunditem(Funditem funditem);

    /**
    *  修改
    * @param funditem
    * @return
    */
    BaseOutput updateFunditem(Funditem funditem);

}