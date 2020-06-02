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
import com.fouo.member.entity.MemberStatisticsInfo;
import com.fouo.member.vo.MemberStatisticsInfoVO;
import com.fouo.member.service.IMemberStatisticsInfoService;

/**
 * 会员统计信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/memberstatisticsinfo")
@Api(value = "会员统计信息", tags = "会员统计信息接口")
public class MemberStatisticsInfoController {

	private IMemberStatisticsInfoService memberStatisticsInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入memberStatisticsInfo")
	public R<MemberStatisticsInfo> detail(MemberStatisticsInfo memberStatisticsInfo) {
		MemberStatisticsInfo detail = memberStatisticsInfoService.getOne(Condition.getQueryWrapper(memberStatisticsInfo));
		return R.data(detail);
	}

	/**
	 * 分页 会员统计信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入memberStatisticsInfo")
	public R<IPage<MemberStatisticsInfo>> list(MemberStatisticsInfo memberStatisticsInfo, Query query) {
		IPage<MemberStatisticsInfo> pages = memberStatisticsInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(memberStatisticsInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员统计信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入memberStatisticsInfo")
	public R<IPage<MemberStatisticsInfoVO>> page(MemberStatisticsInfoVO memberStatisticsInfo, Query query) {
		IPage<MemberStatisticsInfoVO> pages = memberStatisticsInfoService.selectMemberStatisticsInfoPage(Condition.getPage(query), memberStatisticsInfo);
		return R.data(pages);
	}

	/**
	 * 新增 会员统计信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入memberStatisticsInfo")
	public R save(@Valid @RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		return R.status(memberStatisticsInfoService.save(memberStatisticsInfo));
	}

	/**
	 * 修改 会员统计信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入memberStatisticsInfo")
	public R update(@Valid @RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		return R.status(memberStatisticsInfoService.updateById(memberStatisticsInfo));
	}

	/**
	 * 新增或修改 会员统计信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入memberStatisticsInfo")
	public R submit(@Valid @RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		return R.status(memberStatisticsInfoService.saveOrUpdate(memberStatisticsInfo));
	}

	
	/**
	 * 删除 会员统计信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberStatisticsInfoService.removeByIds(Func.toLongList(ids)));
	}

	
}
