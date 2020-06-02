package com.fouo.member.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.member.entity.IntegrationChangeHistory;
import com.fouo.member.vo.IntegrationChangeHistoryVO;
import com.fouo.member.service.IIntegrationChangeHistoryService;

/**
 * 积分变化历史记录 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/integrationchangehistory")
@Api(value = "积分变化历史记录", tags = "积分变化历史记录接口")
public class IntegrationChangeHistoryController {

	private IIntegrationChangeHistoryService integrationChangeHistoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入integrationChangeHistory")
	public R<IntegrationChangeHistory> detail(IntegrationChangeHistory integrationChangeHistory) {
		IntegrationChangeHistory detail = integrationChangeHistoryService.getOne(Condition.getQueryWrapper(integrationChangeHistory));
		return R.data(detail);
	}

	/**
	 * 分页 积分变化历史记录
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入integrationChangeHistory")
	public R<IPage<IntegrationChangeHistory>> list(IntegrationChangeHistory integrationChangeHistory, Query query) {
		IPage<IntegrationChangeHistory> pages = integrationChangeHistoryService.page(Condition.getPage(query), Condition.getQueryWrapper(integrationChangeHistory));
		return R.data(pages);
	}

	/**
	 * 自定义分页 积分变化历史记录
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入integrationChangeHistory")
	public R<IPage<IntegrationChangeHistoryVO>> page(IntegrationChangeHistoryVO integrationChangeHistory, Query query) {
		IPage<IntegrationChangeHistoryVO> pages = integrationChangeHistoryService.selectIntegrationChangeHistoryPage(Condition.getPage(query), integrationChangeHistory);
		return R.data(pages);
	}

	/**
	 * 新增 积分变化历史记录
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入integrationChangeHistory")
	public R save(@Valid @RequestBody IntegrationChangeHistory integrationChangeHistory) {
		return R.status(integrationChangeHistoryService.save(integrationChangeHistory));
	}

	/**
	 * 修改 积分变化历史记录
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入integrationChangeHistory")
	public R update(@Valid @RequestBody IntegrationChangeHistory integrationChangeHistory) {
		return R.status(integrationChangeHistoryService.updateById(integrationChangeHistory));
	}

	/**
	 * 新增或修改 积分变化历史记录
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入integrationChangeHistory")
	public R submit(@Valid @RequestBody IntegrationChangeHistory integrationChangeHistory) {
		return R.status(integrationChangeHistoryService.saveOrUpdate(integrationChangeHistory));
	}

	
	/**
	 * 删除 积分变化历史记录
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(integrationChangeHistoryService.removeByIds(Func.toLongList(ids)));
	}

	
}
