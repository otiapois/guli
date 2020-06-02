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
import com.fouo.coupon.entity.CouponHistory;
import com.fouo.coupon.vo.CouponHistoryVO;
import com.fouo.coupon.service.ICouponHistoryService;

/**
 * 优惠券领取历史记录 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/couponhistory")
@Api(value = "优惠券领取历史记录", tags = "优惠券领取历史记录接口")
public class CouponHistoryController  {

	private ICouponHistoryService couponHistoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入couponHistory")
	public R<CouponHistory> detail(CouponHistory couponHistory) {
		CouponHistory detail = couponHistoryService.getOne(Condition.getQueryWrapper(couponHistory));
		return R.data(detail);
	}

	/**
	 * 分页 优惠券领取历史记录
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入couponHistory")
	public R<IPage<CouponHistory>> list(CouponHistory couponHistory, Query query) {
		IPage<CouponHistory> pages = couponHistoryService.page(Condition.getPage(query), Condition.getQueryWrapper(couponHistory));
		return R.data(pages);
	}

	/**
	 * 自定义分页 优惠券领取历史记录
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入couponHistory")
	public R<IPage<CouponHistoryVO>> page(CouponHistoryVO couponHistory, Query query) {
		IPage<CouponHistoryVO> pages = couponHistoryService.selectCouponHistoryPage(Condition.getPage(query), couponHistory);
		return R.data(pages);
	}

	/**
	 * 新增 优惠券领取历史记录
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入couponHistory")
	public R save(@Valid @RequestBody CouponHistory couponHistory) {
		return R.status(couponHistoryService.save(couponHistory));
	}

	/**
	 * 修改 优惠券领取历史记录
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入couponHistory")
	public R update(@Valid @RequestBody CouponHistory couponHistory) {
		return R.status(couponHistoryService.updateById(couponHistory));
	}

	/**
	 * 新增或修改 优惠券领取历史记录
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入couponHistory")
	public R submit(@Valid @RequestBody CouponHistory couponHistory) {
		return R.status(couponHistoryService.saveOrUpdate(couponHistory));
	}

	
	/**
	 * 删除 优惠券领取历史记录
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(couponHistoryService.removeByIds(Func.toLongList(ids)));
	}

	
}
