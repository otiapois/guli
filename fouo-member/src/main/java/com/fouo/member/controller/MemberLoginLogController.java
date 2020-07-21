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
import com.fouo.member.entity.MemberLoginLog;
import com.fouo.member.vo.MemberLoginLogVO;
import com.fouo.member.service.IMemberLoginLogService;

/**
 * 会员登录记录 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member/memberloginlog")
@Api(value = "会员登录记录", tags = "会员登录记录接口")
public class MemberLoginLogController{

	private IMemberLoginLogService memberLoginLogService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入memberLoginLog")
	public R<MemberLoginLog> detail(MemberLoginLog memberLoginLog) {
		MemberLoginLog detail = memberLoginLogService.getOne(Condition.getQueryWrapper(memberLoginLog));
		return R.data(detail);
	}

	/**
	 * 分页 会员登录记录
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入memberLoginLog")
	public R<IPage<MemberLoginLog>> list(MemberLoginLog memberLoginLog, Query query) {
		IPage<MemberLoginLog> pages = memberLoginLogService.page(Condition.getPage(query), Condition.getQueryWrapper(memberLoginLog));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员登录记录
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入memberLoginLog")
	public R<IPage<MemberLoginLogVO>> page(MemberLoginLogVO memberLoginLog, Query query) {
		IPage<MemberLoginLogVO> pages = memberLoginLogService.selectMemberLoginLogPage(Condition.getPage(query), memberLoginLog);
		return R.data(pages);
	}

	/**
	 * 新增 会员登录记录
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入memberLoginLog")
	public R save(@Valid @RequestBody MemberLoginLog memberLoginLog) {
		return R.status(memberLoginLogService.save(memberLoginLog));
	}

	/**
	 * 修改 会员登录记录
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入memberLoginLog")
	public R update(@Valid @RequestBody MemberLoginLog memberLoginLog) {
		return R.status(memberLoginLogService.updateById(memberLoginLog));
	}

	/**
	 * 新增或修改 会员登录记录
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入memberLoginLog")
	public R submit(@Valid @RequestBody MemberLoginLog memberLoginLog) {
		return R.status(memberLoginLogService.saveOrUpdate(memberLoginLog));
	}

	
	/**
	 * 删除 会员登录记录
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberLoginLogService.removeByIds(Func.toLongList(ids)));
	}

	
}
