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
import com.fouo.coupon.entity.SkuFullReduction;
import com.fouo.coupon.vo.SkuFullReductionVO;
import com.fouo.coupon.service.ISkuFullReductionService;

/**
 * 商品满减信息 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skufullreduction")
@Api(value = "商品满减信息", tags = "商品满减信息接口")
public class SkuFullReductionController  {

	private ISkuFullReductionService skuFullReductionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入skuFullReduction")
	public R<SkuFullReduction> detail(SkuFullReduction skuFullReduction) {
		SkuFullReduction detail = skuFullReductionService.getOne(Condition.getQueryWrapper(skuFullReduction));
		return R.data(detail);
	}

	/**
	 * 分页 商品满减信息
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入skuFullReduction")
	public R<IPage<SkuFullReduction>> list(SkuFullReduction skuFullReduction, Query query) {
		IPage<SkuFullReduction> pages = skuFullReductionService.page(Condition.getPage(query), Condition.getQueryWrapper(skuFullReduction));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品满减信息
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入skuFullReduction")
	public R<IPage<SkuFullReductionVO>> page(SkuFullReductionVO skuFullReduction, Query query) {
		IPage<SkuFullReductionVO> pages = skuFullReductionService.selectSkuFullReductionPage(Condition.getPage(query), skuFullReduction);
		return R.data(pages);
	}

	/**
	 * 新增 商品满减信息
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入skuFullReduction")
	public R save(@Valid @RequestBody SkuFullReduction skuFullReduction) {
		return R.status(skuFullReductionService.save(skuFullReduction));
	}

	/**
	 * 修改 商品满减信息
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入skuFullReduction")
	public R update(@Valid @RequestBody SkuFullReduction skuFullReduction) {
		return R.status(skuFullReductionService.updateById(skuFullReduction));
	}

	/**
	 * 新增或修改 商品满减信息
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入skuFullReduction")
	public R submit(@Valid @RequestBody SkuFullReduction skuFullReduction) {
		return R.status(skuFullReductionService.saveOrUpdate(skuFullReduction));
	}

	
	/**
	 * 删除 商品满减信息
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuFullReductionService.removeByIds(Func.toLongList(ids)));
	}

	
}
