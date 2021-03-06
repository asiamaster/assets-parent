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
package com.dili.assets.mapper;

import com.dili.ss.base.MyMapper;
import com.dili.assets.domain.Config;
import com.dili.assets.sdk.dto.ConfigQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-08-13
 **/
public interface ConfigMapper extends MyMapper<Config> {

    List<Config> selectByQuery(ConfigQuery query);

    List<Config> selectAllByType(@Param("type") String type);
}