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
import com.fouo.member.entity.MemberLevel;
import com.fouo.member.vo.MemberLevelVO;
import com.fouo.member.service.IMemberLevelService;

/**
 * 会员等级 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/memberlevel")
@Api(value = "会员等级", tags = "会员等级接口")
public class MemberLevelController{

	private IMemberLevelService memberLevelService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入memberLevel")
	public R<MemberLevel> detail(MemberLevel memberLevel) {
		MemberLevel detail = memberLevelService.getOne(Condition.getQueryWrapper(memberLevel));
		return R.data(detail);
	}

	/**
	 * 分页 会员等级
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入memberLevel")
	public R<IPage<MemberLevel>> list(MemberLevel memberLevel, Query query) {
		IPage<MemberLevel> pages = memberLevelService.page(Condition.getPage(query), Condition.getQueryWrapper(memberLevel));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员等级
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入memberLevel")
	public R<IPage<MemberLevelVO>> page(MemberLevelVO memberLevel, Query query) {
		IPage<MemberLevelVO> pages = memberLevelService.selectMemberLevelPage(Condition.getPage(query), memberLevel);
		return R.data(pages);
	}

	/**
	 * 新增 会员等级
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入memberLevel")
	public R save(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.save(memberLevel));
	}

	/**
	 * 修改 会员等级
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入memberLevel")
	public R update(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.updateById(memberLevel));
	}

	/**
	 * 新增或修改 会员等级
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入memberLevel")
	public R submit(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.saveOrUpdate(memberLevel));
	}

	
	/**
	 * 删除 会员等级
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberLevelService.removeByIds(Func.toLongList(ids)));
	}

	
}
