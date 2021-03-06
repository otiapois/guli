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
@RequestMapping("/member/memberlevel")
@Api(value = "会员等级", tags = "会员等级接口")
public class MemberLevelController{

	private IMemberLevelService memberLevelService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入memberLevel")
	public R<MemberLevel> detail(MemberLevelVO memberLevelVO) {
		MemberLevel detail = memberLevelService.getOne(Condition.getQueryWrapper(memberLevelVO));
		return R.data(detail);
	}

	/**
	 * 分页 会员等级
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入memberLevel")
	public R<IPage<MemberLevel>> list(MemberLevelVO memberLevelVO, Query query) {
		IPage<MemberLevel> pages = memberLevelService.page(Condition.getPage(query), Condition.getQueryWrapper(memberLevelVO));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员等级
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入memberLevel")
	public R<IPage<MemberLevelVO>> page(MemberLevelVO memberLevel, Query query) {
		IPage<MemberLevelVO> pages = memberLevelService.selectMemberLevelPage(Condition.getPage(query), memberLevel);
		return R.data(pages);
	}

	/**
	 * 新增 会员等级
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入memberLevel")
	public R save(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.save(memberLevel));
	}

	/**
	 * 修改 会员等级
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入memberLevel")
	public R update(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.updateById(memberLevel));
	}

	/**
	 * 新增或修改 会员等级
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入memberLevel")
	public R submit(@Valid @RequestBody MemberLevel memberLevel) {
		return R.status(memberLevelService.saveOrUpdate(memberLevel));
	}

	
	/**
	 * 删除 会员等级
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberLevelService.removeByIds(Func.toLongList(ids)));
	}

	
}
