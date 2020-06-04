package com.fouo.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fouo.common.support.Condition;
import com.fouo.common.support.Query;
import com.fouo.common.support.R;
import com.fouo.common.utils.Func;
import com.fouo.product.entity.SkuInfo;
import com.fouo.product.service.ISkuInfoService;
import com.fouo.product.vo.SkuInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * sku信息 控制器
 *
 * @author fouo
 * @since 2020-06-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skuinfo")
@Api(value = "sku信息", tags = "sku信息接口")
public class SkuInfoController{

	private ISkuInfoService skuInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入skuInfo")
	public R<SkuInfo> detail(SkuInfo skuInfo) {
		SkuInfo detail = skuInfoService.getOne(Condition.getQueryWrapper(skuInfo));
		return R.data(detail);
	}

	/**
	 * 分页 sku信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入skuInfo")
	public R<IPage<SkuInfo>> list(SkuInfo skuInfo, Query query) {
		IPage<SkuInfo> pages = skuInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(skuInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页 sku信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入skuInfo")
	public R<IPage<SkuInfoVO>> page(SkuInfoVO skuInfo, Query query) {
		IPage<SkuInfoVO> pages = skuInfoService.selectSkuInfoPage(Condition.getPage(query), skuInfo);
		return R.data(pages);
	}

	/**
	 * 新增 sku信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入skuInfo")
	public R save(@Valid @RequestBody SkuInfo skuInfo) {
		return R.status(skuInfoService.save(skuInfo));
	}

	/**
	 * 修改 sku信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入skuInfo")
	public R update(@Valid @RequestBody SkuInfo skuInfo) {
		return R.status(skuInfoService.updateById(skuInfo));
	}

	/**
	 * 新增或修改 sku信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入skuInfo")
	public R submit(@Valid @RequestBody SkuInfo skuInfo) {
		return R.status(skuInfoService.saveOrUpdate(skuInfo));
	}

	
	/**
	 * 删除 sku信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuInfoService.removeByIds(Func.toLongList(ids)));
	}

	
}
