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

import com.dili.ss.domain.BaseDomain;
import lombok.Data;

import java.io.Serializable;

/**
* @website http://shaofan.org
* @description /
* @author shaofan
* @date 2020-08-13
**/
@Data
public class ConfigDto extends BaseDomain implements Serializable {

    /** id */
    private Long id;

    /** 配置项 */
    private String name;

    /** 值 */
    private String value;

    /** 备注 */
    private String notes;

    /** 状态 */
    private Integer state;

    /** 市场 */
    private Long marketId;

    /** 分组 */
    private String type;
}