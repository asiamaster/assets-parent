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

import com.dili.commons.bstable.Tablepar;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shaofan
 * @website http://shaofan.org
 * @date 2020-10-15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PosMarketQuery extends Tablepar {

    private String name;
    private String area;
    private Long marketId;
    private String keyword;
}