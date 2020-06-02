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
import com.fouo.member.entity.MemberCollectSubject;
import com.fouo.member.vo.MemberCollectSubjectVO;
import com.fouo.member.service.IMemberCollectSubjectService;

/**
 * 会员收藏的专题活动 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/membercollectsubject")
@Api(value = "会员收藏的专题活动", tags = "会员收藏的专题活动接口")
public class MemberCollectSubjectController  {

	private IMemberCollectSubjectService memberCollectSubjectService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入memberCollectSubject")
	public R<MemberCollectSubject> detail(MemberCollectSubject memberCollectSubject) {
		MemberCollectSubject detail = memberCollectSubjectService.getOne(Condition.getQueryWrapper(memberCollectSubject));
		return R.data(detail);
	}

	/**
	 * 分页 会员收藏的专题活动
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入memberCollectSubject")
	public R<IPage<MemberCollectSubject>> list(MemberCollectSubject memberCollectSubject, Query query) {
		IPage<MemberCollectSubject> pages = memberCollectSubjectService.page(Condition.getPage(query), Condition.getQueryWrapper(memberCollectSubject));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员收藏的专题活动
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入memberCollectSubject")
	public R<IPage<MemberCollectSubjectVO>> page(MemberCollectSubjectVO memberCollectSubject, Query query) {
		IPage<MemberCollectSubjectVO> pages = memberCollectSubjectService.selectMemberCollectSubjectPage(Condition.getPage(query), memberCollectSubject);
		return R.data(pages);
	}

	/**
	 * 新增 会员收藏的专题活动
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入memberCollectSubject")
	public R save(@Valid @RequestBody MemberCollectSubject memberCollectSubject) {
		return R.status(memberCollectSubjectService.save(memberCollectSubject));
	}

	/**
	 * 修改 会员收藏的专题活动
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入memberCollectSubject")
	public R update(@Valid @RequestBody MemberCollectSubject memberCollectSubject) {
		return R.status(memberCollectSubjectService.updateById(memberCollectSubject));
	}

	/**
	 * 新增或修改 会员收藏的专题活动
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入memberCollectSubject")
	public R submit(@Valid @RequestBody MemberCollectSubject memberCollectSubject) {
		return R.status(memberCollectSubjectService.saveOrUpdate(memberCollectSubject));
	}

	
	/**
	 * 删除 会员收藏的专题活动
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberCollectSubjectService.removeByIds(Func.toLongList(ids)));
	}

	
}
