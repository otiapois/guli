package com.fouo.coupon.controller;

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
import com.fouo.coupon.entity.MemberPrice;
import com.fouo.coupon.vo.MemberPriceVO;
import com.fouo.coupon.service.IMemberPriceService;

/**
 * 商品会员价格 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/memberprice")
@Api(value = "商品会员价格", tags = "商品会员价格接口")
public class MemberPriceController {

	private IMemberPriceService memberPriceService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入memberPrice")
	public R<MemberPrice> detail(MemberPrice memberPrice) {
		MemberPrice detail = memberPriceService.getOne(Condition.getQueryWrapper(memberPrice));
		return R.data(detail);
	}

	/**
	 * 分页 商品会员价格
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入memberPrice")
	public R<IPage<MemberPrice>> list(MemberPrice memberPrice, Query query) {
		IPage<MemberPrice> pages = memberPriceService.page(Condition.getPage(query), Condition.getQueryWrapper(memberPrice));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品会员价格
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入memberPrice")
	public R<IPage<MemberPriceVO>> page(MemberPriceVO memberPrice, Query query) {
		IPage<MemberPriceVO> pages = memberPriceService.selectMemberPricePage(Condition.getPage(query), memberPrice);
		return R.data(pages);
	}

	/**
	 * 新增 商品会员价格
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入memberPrice")
	public R save(@Valid @RequestBody MemberPrice memberPrice) {
		return R.status(memberPriceService.save(memberPrice));
	}

	/**
	 * 修改 商品会员价格
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入memberPrice")
	public R update(@Valid @RequestBody MemberPrice memberPrice) {
		return R.status(memberPriceService.updateById(memberPrice));
	}

	/**
	 * 新增或修改 商品会员价格
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入memberPrice")
	public R submit(@Valid @RequestBody MemberPrice memberPrice) {
		return R.status(memberPriceService.saveOrUpdate(memberPrice));
	}

	
	/**
	 * 删除 商品会员价格
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberPriceService.removeByIds(Func.toLongList(ids)));
	}

	
}
