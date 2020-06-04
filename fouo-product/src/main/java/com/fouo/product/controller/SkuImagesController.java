package com.fouo.product.controller;

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
import com.fouo.product.entity.SkuImages;
import com.fouo.product.vo.SkuImagesVO;
import com.fouo.product.service.ISkuImagesService;

/**
 * sku图片 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skuimages")
@Api(value = "sku图片", tags = "sku图片接口")
public class SkuImagesController{

	private ISkuImagesService skuImagesService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入skuImages")
	public R<SkuImages> detail(SkuImages skuImages) {
		SkuImages detail = skuImagesService.getOne(Condition.getQueryWrapper(skuImages));
		return R.data(detail);
	}

	/**
	 * 分页 sku图片
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入skuImages")
	public R<IPage<SkuImages>> list(SkuImages skuImages, Query query) {
		IPage<SkuImages> pages = skuImagesService.page(Condition.getPage(query), Condition.getQueryWrapper(skuImages));
		return R.data(pages);
	}

	/**
	 * 自定义分页 sku图片
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入skuImages")
	public R<IPage<SkuImagesVO>> page(SkuImagesVO skuImages, Query query) {
		IPage<SkuImagesVO> pages = skuImagesService.selectSkuImagesPage(Condition.getPage(query), skuImages);
		return R.data(pages);
	}

	/**
	 * 新增 sku图片
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入skuImages")
	public R save(@Valid @RequestBody SkuImages skuImages) {
		return R.status(skuImagesService.save(skuImages));
	}

	/**
	 * 修改 sku图片
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入skuImages")
	public R update(@Valid @RequestBody SkuImages skuImages) {
		return R.status(skuImagesService.updateById(skuImages));
	}

	/**
	 * 新增或修改 sku图片
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入skuImages")
	public R submit(@Valid @RequestBody SkuImages skuImages) {
		return R.status(skuImagesService.saveOrUpdate(skuImages));
	}

	
	/**
	 * 删除 sku图片
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuImagesService.removeByIds(Func.toLongList(ids)));
	}

	
}
