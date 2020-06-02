package com.fouo.coupon.controller;

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
import com.fouo.coupon.entity.CouponSpuRelation;
import com.fouo.coupon.vo.CouponSpuRelationVO;
import com.fouo.coupon.service.ICouponSpuRelationService;

/**
 * 优惠券与产品关联 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/couponspurelation")
@Api(value = "优惠券与产品关联", tags = "优惠券与产品关联接口")
public class CouponSpuRelationController{

	private ICouponSpuRelationService couponSpuRelationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入couponSpuRelation")
	public R<CouponSpuRelation> detail(CouponSpuRelation couponSpuRelation) {
		CouponSpuRelation detail = couponSpuRelationService.getOne(Condition.getQueryWrapper(couponSpuRelation));
		return R.data(detail);
	}

	/**
	 * 分页 优惠券与产品关联
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入couponSpuRelation")
	public R<IPage<CouponSpuRelation>> list(CouponSpuRelation couponSpuRelation, Query query) {
		IPage<CouponSpuRelation> pages = couponSpuRelationService.page(Condition.getPage(query), Condition.getQueryWrapper(couponSpuRelation));
		return R.data(pages);
	}

	/**
	 * 自定义分页 优惠券与产品关联
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入couponSpuRelation")
	public R<IPage<CouponSpuRelationVO>> page(CouponSpuRelationVO couponSpuRelation, Query query) {
		IPage<CouponSpuRelationVO> pages = couponSpuRelationService.selectCouponSpuRelationPage(Condition.getPage(query), couponSpuRelation);
		return R.data(pages);
	}

	/**
	 * 新增 优惠券与产品关联
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入couponSpuRelation")
	public R save(@Valid @RequestBody CouponSpuRelation couponSpuRelation) {
		return R.status(couponSpuRelationService.save(couponSpuRelation));
	}

	/**
	 * 修改 优惠券与产品关联
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入couponSpuRelation")
	public R update(@Valid @RequestBody CouponSpuRelation couponSpuRelation) {
		return R.status(couponSpuRelationService.updateById(couponSpuRelation));
	}

	/**
	 * 新增或修改 优惠券与产品关联
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入couponSpuRelation")
	public R submit(@Valid @RequestBody CouponSpuRelation couponSpuRelation) {
		return R.status(couponSpuRelationService.saveOrUpdate(couponSpuRelation));
	}

	
	/**
	 * 删除 优惠券与产品关联
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(couponSpuRelationService.removeByIds(Func.toLongList(ids)));
	}

	
}
