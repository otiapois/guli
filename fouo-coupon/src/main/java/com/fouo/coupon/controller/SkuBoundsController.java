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
import com.fouo.coupon.entity.SkuBounds;
import com.fouo.coupon.vo.SkuBoundsVO;
import com.fouo.coupon.service.ISkuBoundsService;

/**
 * 商品sku积分设置 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skubounds")
@Api(value = "商品sku积分设置", tags = "商品sku积分设置接口")
public class SkuBoundsController {

	private ISkuBoundsService skuBoundsService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入skuBounds")
	public R<SkuBounds> detail(SkuBounds skuBounds) {
		SkuBounds detail = skuBoundsService.getOne(Condition.getQueryWrapper(skuBounds));
		return R.data(detail);
	}

	/**
	 * 分页 商品sku积分设置
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入skuBounds")
	public R<IPage<SkuBounds>> list(SkuBounds skuBounds, Query query) {
		IPage<SkuBounds> pages = skuBoundsService.page(Condition.getPage(query), Condition.getQueryWrapper(skuBounds));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品sku积分设置
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入skuBounds")
	public R<IPage<SkuBoundsVO>> page(SkuBoundsVO skuBounds, Query query) {
		IPage<SkuBoundsVO> pages = skuBoundsService.selectSkuBoundsPage(Condition.getPage(query), skuBounds);
		return R.data(pages);
	}

	/**
	 * 新增 商品sku积分设置
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入skuBounds")
	public R save(@Valid @RequestBody SkuBounds skuBounds) {
		return R.status(skuBoundsService.save(skuBounds));
	}

	/**
	 * 修改 商品sku积分设置
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入skuBounds")
	public R update(@Valid @RequestBody SkuBounds skuBounds) {
		return R.status(skuBoundsService.updateById(skuBounds));
	}

	/**
	 * 新增或修改 商品sku积分设置
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入skuBounds")
	public R submit(@Valid @RequestBody SkuBounds skuBounds) {
		return R.status(skuBoundsService.saveOrUpdate(skuBounds));
	}

	
	/**
	 * 删除 商品sku积分设置
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuBoundsService.removeByIds(Func.toLongList(ids)));
	}

	
}
