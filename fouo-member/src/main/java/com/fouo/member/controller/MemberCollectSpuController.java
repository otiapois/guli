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
import com.fouo.member.entity.MemberCollectSpu;
import com.fouo.member.vo.MemberCollectSpuVO;
import com.fouo.member.service.IMemberCollectSpuService;

/**
 * 会员收藏的商品 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member/membercollectspu")
@Api(value = "会员收藏的商品", tags = "会员收藏的商品接口")
public class MemberCollectSpuController {

	private IMemberCollectSpuService memberCollectSpuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入memberCollectSpu")
	public R<MemberCollectSpu> detail(MemberCollectSpu memberCollectSpu) {
		MemberCollectSpu detail = memberCollectSpuService.getOne(Condition.getQueryWrapper(memberCollectSpu));
		return R.data(detail);
	}

	/**
	 * 分页 会员收藏的商品
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入memberCollectSpu")
	public R<IPage<MemberCollectSpu>> list(MemberCollectSpu memberCollectSpu, Query query) {
		IPage<MemberCollectSpu> pages = memberCollectSpuService.page(Condition.getPage(query), Condition.getQueryWrapper(memberCollectSpu));
		return R.data(pages);
	}

	/**
	 * 自定义分页 会员收藏的商品
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入memberCollectSpu")
	public R<IPage<MemberCollectSpuVO>> page(MemberCollectSpuVO memberCollectSpu, Query query) {
		IPage<MemberCollectSpuVO> pages = memberCollectSpuService.selectMemberCollectSpuPage(Condition.getPage(query), memberCollectSpu);
		return R.data(pages);
	}

	/**
	 * 新增 会员收藏的商品
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入memberCollectSpu")
	public R save(@Valid @RequestBody MemberCollectSpu memberCollectSpu) {
		return R.status(memberCollectSpuService.save(memberCollectSpu));
	}

	/**
	 * 修改 会员收藏的商品
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入memberCollectSpu")
	public R update(@Valid @RequestBody MemberCollectSpu memberCollectSpu) {
		return R.status(memberCollectSpuService.updateById(memberCollectSpu));
	}

	/**
	 * 新增或修改 会员收藏的商品
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入memberCollectSpu")
	public R submit(@Valid @RequestBody MemberCollectSpu memberCollectSpu) {
		return R.status(memberCollectSpuService.saveOrUpdate(memberCollectSpu));
	}

	
	/**
	 * 删除 会员收藏的商品
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberCollectSpuService.removeByIds(Func.toLongList(ids)));
	}

	
}
