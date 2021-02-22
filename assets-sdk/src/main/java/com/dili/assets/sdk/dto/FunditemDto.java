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
import com.dili.ss.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/**
* @website http://shaofan.org
* @description /
* @author shaofan
* @date 2021-02-22
**/
@Data
public class FunditemDto extends BaseDomain implements Serializable {

    /** id */
    private Long id;

    /** 资金项名称 */
    private String name;

    /** 状态 */
    private Integer state;

    /** 市场 */
    private String marketId;
}