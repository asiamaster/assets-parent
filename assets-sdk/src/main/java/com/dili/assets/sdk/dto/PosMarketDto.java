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
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * @website http://shaofan.org
 * @description /
 * @author shaofan
 * @date 2020-10-15
 **/
@Data
public class PosMarketDto extends BaseDomain implements Serializable {

	/** 创建人 */
	private String creatorId;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdTime;

	/** 所属市场 */
	private Long market;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyTime;

	/** 市场名称 */
	private String name;

	/** 区域名称 */
	private String areaName;

	/** 所属区域 */
	private String area;

	/** 备注 */
	private String notes;

	/** 主键 */
	private Long id;
}