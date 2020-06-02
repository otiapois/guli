package com.fouo.product.controller;

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
import com.fouo.product.entity.SkuSaleAttrValue;
import com.fouo.product.vo.SkuSaleAttrValueVO;
import com.fouo.product.service.ISkuSaleAttrValueService;

/**
 * sku销售属性&值 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skusaleattrvalue")
@Api(value = "sku销售属性&值", tags = "sku销售属性&值接口")
public class SkuSaleAttrValueController {

	private ISkuSaleAttrValueService skuSaleAttrValueService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入skuSaleAttrValue")
	public R<SkuSaleAttrValue> detail(SkuSaleAttrValue skuSaleAttrValue) {
		SkuSaleAttrValue detail = skuSaleAttrValueService.getOne(Condition.getQueryWrapper(skuSaleAttrValue));
		return R.data(detail);
	}

	/**
	 * 分页 sku销售属性&值
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入skuSaleAttrValue")
	public R<IPage<SkuSaleAttrValue>> list(SkuSaleAttrValue skuSaleAttrValue, Query query) {
		IPage<SkuSaleAttrValue> pages = skuSaleAttrValueService.page(Condition.getPage(query), Condition.getQueryWrapper(skuSaleAttrValue));
		return R.data(pages);
	}

	/**
	 * 自定义分页 sku销售属性&值
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入skuSaleAttrValue")
	public R<IPage<SkuSaleAttrValueVO>> page(SkuSaleAttrValueVO skuSaleAttrValue, Query query) {
		IPage<SkuSaleAttrValueVO> pages = skuSaleAttrValueService.selectSkuSaleAttrValuePage(Condition.getPage(query), skuSaleAttrValue);
		return R.data(pages);
	}

	/**
	 * 新增 sku销售属性&值
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入skuSaleAttrValue")
	public R save(@Valid @RequestBody SkuSaleAttrValue skuSaleAttrValue) {
		return R.status(skuSaleAttrValueService.save(skuSaleAttrValue));
	}

	/**
	 * 修改 sku销售属性&值
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入skuSaleAttrValue")
	public R update(@Valid @RequestBody SkuSaleAttrValue skuSaleAttrValue) {
		return R.status(skuSaleAttrValueService.updateById(skuSaleAttrValue));
	}

	/**
	 * 新增或修改 sku销售属性&值
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入skuSaleAttrValue")
	public R submit(@Valid @RequestBody SkuSaleAttrValue skuSaleAttrValue) {
		return R.status(skuSaleAttrValueService.saveOrUpdate(skuSaleAttrValue));
	}

	
	/**
	 * 删除 sku销售属性&值
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuSaleAttrValueService.removeByIds(Func.toLongList(ids)));
	}

	
}
