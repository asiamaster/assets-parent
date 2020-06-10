package com.dili.assets.controller;

import com.dili.assets.domain.BankUnionInfo;
import com.dili.assets.service.BankUnionInfoService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成 This file was generated on 2020-05-25 16:11:17.
 */
@RestController
@RequestMapping("/api/bankUnionInfo")
public class BankUnionInfoController {
	@Autowired
	BankUnionInfoService bankUnionInfoService;

	/**
	 * 查询联行号列表
	 * 
	 * @param bankUnionInfo
	 * @return
	 */
	@PostMapping("/list")
	public BaseOutput<List<BankUnionInfo>> list(@RequestBody BankUnionInfo bankUnionInfo) {
		return BaseOutput.success().setData(this.bankUnionInfoService.list(bankUnionInfo));
	}
}