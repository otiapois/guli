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
import com.fouo.coupon.entity.CouponSpuCategoryRelation;
import com.fouo.coupon.vo.CouponSpuCategoryRelationVO;
import com.fouo.coupon.service.ICouponSpuCategoryRelationService;

/**
 * 优惠券分类关联 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/couponspucategoryrelation")
@Api(value = "优惠券分类关联", tags = "优惠券分类关联接口")
public class CouponSpuCategoryRelationController {

	private ICouponSpuCategoryRelationService couponSpuCategoryRelationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入couponSpuCategoryRelation")
	public R<CouponSpuCategoryRelation> detail(CouponSpuCategoryRelation couponSpuCategoryRelation) {
		CouponSpuCategoryRelation detail = couponSpuCategoryRelationService.getOne(Condition.getQueryWrapper(couponSpuCategoryRelation));
		return R.data(detail);
	}

	/**
	 * 分页 优惠券分类关联
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入couponSpuCategoryRelation")
	public R<IPage<CouponSpuCategoryRelation>> list(CouponSpuCategoryRelation couponSpuCategoryRelation, Query query) {
		IPage<CouponSpuCategoryRelation> pages = couponSpuCategoryRelationService.page(Condition.getPage(query), Condition.getQueryWrapper(couponSpuCategoryRelation));
		return R.data(pages);
	}

	/**
	 * 自定义分页 优惠券分类关联
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入couponSpuCategoryRelation")
	public R<IPage<CouponSpuCategoryRelationVO>> page(CouponSpuCategoryRelationVO couponSpuCategoryRelation, Query query) {
		IPage<CouponSpuCategoryRelationVO> pages = couponSpuCategoryRelationService.selectCouponSpuCategoryRelationPage(Condition.getPage(query), couponSpuCategoryRelation);
		return R.data(pages);
	}

	/**
	 * 新增 优惠券分类关联
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入couponSpuCategoryRelation")
	public R save(@Valid @RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
		return R.status(couponSpuCategoryRelationService.save(couponSpuCategoryRelation));
	}

	/**
	 * 修改 优惠券分类关联
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入couponSpuCategoryRelation")
	public R update(@Valid @RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
		return R.status(couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation));
	}

	/**
	 * 新增或修改 优惠券分类关联
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入couponSpuCategoryRelation")
	public R submit(@Valid @RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation) {
		return R.status(couponSpuCategoryRelationService.saveOrUpdate(couponSpuCategoryRelation));
	}

	
	/**
	 * 删除 优惠券分类关联
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(couponSpuCategoryRelationService.removeByIds(Func.toLongList(ids)));
	}

	
}
