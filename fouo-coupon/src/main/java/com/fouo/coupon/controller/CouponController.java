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
import com.fouo.coupon.entity.Coupon;
import com.fouo.coupon.vo.CouponVO;
import com.fouo.coupon.service.ICouponService;

/**
 * 优惠券信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/coupon")
@Api(value = "优惠券信息", tags = "优惠券信息接口")
public class CouponController {

	private ICouponService couponService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入coupon")
	public R<Coupon> detail(Coupon coupon) {
		Coupon detail = couponService.getOne(Condition.getQueryWrapper(coupon));
		return R.data(detail);
	}

	/**
	 * 分页 优惠券信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入coupon")
	public R<IPage<Coupon>> list(Coupon coupon, Query query) {
		IPage<Coupon> pages = couponService.page(Condition.getPage(query), Condition.getQueryWrapper(coupon));
		return R.data(pages);
	}

	/**
	 * 自定义分页 优惠券信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入coupon")
	public R<IPage<CouponVO>> page(CouponVO coupon, Query query) {
		IPage<CouponVO> pages = couponService.selectCouponPage(Condition.getPage(query), coupon);
		return R.data(pages);
	}

	/**
	 * 新增 优惠券信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入coupon")
	public R save(@Valid @RequestBody Coupon coupon) {
		return R.status(couponService.save(coupon));
	}

	/**
	 * 修改 优惠券信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入coupon")
	public R update(@Valid @RequestBody Coupon coupon) {
		return R.status(couponService.updateById(coupon));
	}

	/**
	 * 新增或修改 优惠券信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入coupon")
	public R submit(@Valid @RequestBody Coupon coupon) {
		return R.status(couponService.saveOrUpdate(coupon));
	}

	
	/**
	 * 删除 优惠券信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(couponService.removeByIds(Func.toLongList(ids)));
	}

	
}
