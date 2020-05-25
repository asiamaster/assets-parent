package com.dili.assets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dili.assets.domain.Bank;
import com.dili.assets.service.BankService;
import com.dili.ss.domain.BaseOutput;

import io.swagger.annotations.Api;

/**
 * 由MyBatis Generator工具自动生成 This file was generated on 2020-05-25 16:10:36.
 */
@Api("/bank")
@RestController
@RequestMapping("/api/bank")
public class BankController {
	@Autowired
	BankService bankService;

	/**
	 * 查询银行列表
	 * 
	 * @param bank
	 * @return
	 */
	@PostMapping("/list")
	public BaseOutput<List<Bank>> list(@RequestBody Bank bank) {
		return BaseOutput.success().setData(this.bankService.list(bank));
	}
}