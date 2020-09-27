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
package com.dili.assets.sdk.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-08-13
 **/
@Data
public class CusCategoryQuery {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 用于快速查找整棵品类树 where path like '1,2,3,%'
     */
    private String queryPath;

    private List<String> ids;

    private Long marketId;

    private Long parent;

    private Integer state;
}