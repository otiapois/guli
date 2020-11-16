package com.fouo.member.controller;

import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.member.entity.GrowthChangeHistory;
import com.fouo.member.vo.GrowthChangeHistoryVO;
import com.fouo.member.service.IGrowthChangeHistoryService;

/**
 * 成长值变化历史记录 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member/growthchangehistory")
@Api(value = "成长值变化历史记录", tags = "成长值变化历史记录接口")
public class GrowthChangeHistoryController {

	private IGrowthChangeHistoryService growthChangeHistoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入growthChangeHistory")
	public R<GrowthChangeHistory> detail(GrowthChangeHistory growthChangeHistory) {
		GrowthChangeHistory detail = growthChangeHistoryService.getOne(Condition.getQueryWrapper(growthChangeHistory));
		return R.data(detail);
	}

	/**
	 * 分页 成长值变化历史记录
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入growthChangeHistory")
	public R<IPage<GrowthChangeHistory>> list(GrowthChangeHistory growthChangeHistory, Query query) {
		IPage<GrowthChangeHistory> pages = growthChangeHistoryService.page(Condition.getPage(query), Condition.getQueryWrapper(growthChangeHistory));
		return R.data(pages);
	}

	/**
	 * 自定义分页 成长值变化历史记录
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入growthChangeHistory")
	public R<IPage<GrowthChangeHistoryVO>> page(GrowthChangeHistoryVO growthChangeHistory, Query query) {
		IPage<GrowthChangeHistoryVO> pages = growthChangeHistoryService.selectGrowthChangeHistoryPage(Condition.getPage(query), growthChangeHistory);
		return R.data(pages);
	}

	/**
	 * 新增 成长值变化历史记录
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入growthChangeHistory")
	public R save(@Valid @RequestBody GrowthChangeHistory growthChangeHistory) {
		return R.status(growthChangeHistoryService.save(growthChangeHistory));
	}

	/**
	 * 修改 成长值变化历史记录
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入growthChangeHistory")
	public R update(@Valid @RequestBody GrowthChangeHistory growthChangeHistory) {
		return R.status(growthChangeHistoryService.updateById(growthChangeHistory));
	}

	/**
	 * 新增或修改 成长值变化历史记录
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入growthChangeHistory")
	public R submit(@Valid @RequestBody GrowthChangeHistory growthChangeHistory) {
		return R.status(growthChangeHistoryService.saveOrUpdate(growthChangeHistory));
	}

	
	/**
	 * 删除 成长值变化历史记录
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(growthChangeHistoryService.removeByIds(Func.toLongList(ids)));
	}

	
}
