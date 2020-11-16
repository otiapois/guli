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
import com.fouo.coupon.entity.SkuLadder;
import com.fouo.coupon.vo.SkuLadderVO;
import com.fouo.coupon.service.ISkuLadderService;

/**
 * 商品阶梯价格 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/skuladder")
@Api(value = "商品阶梯价格", tags = "商品阶梯价格接口")
public class SkuLadderController  {

	private ISkuLadderService skuLadderService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入skuLadder")
	public R<SkuLadder> detail(SkuLadder skuLadder) {
		SkuLadder detail = skuLadderService.getOne(Condition.getQueryWrapper(skuLadder));
		return R.data(detail);
	}

	/**
	 * 分页 商品阶梯价格
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入skuLadder")
	public R<IPage<SkuLadder>> list(SkuLadder skuLadder, Query query) {
		IPage<SkuLadder> pages = skuLadderService.page(Condition.getPage(query), Condition.getQueryWrapper(skuLadder));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品阶梯价格
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入skuLadder")
	public R<IPage<SkuLadderVO>> page(SkuLadderVO skuLadder, Query query) {
		IPage<SkuLadderVO> pages = skuLadderService.selectSkuLadderPage(Condition.getPage(query), skuLadder);
		return R.data(pages);
	}

	/**
	 * 新增 商品阶梯价格
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入skuLadder")
	public R save(@Valid @RequestBody SkuLadder skuLadder) {
		return R.status(skuLadderService.save(skuLadder));
	}

	/**
	 * 修改 商品阶梯价格
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入skuLadder")
	public R update(@Valid @RequestBody SkuLadder skuLadder) {
		return R.status(skuLadderService.updateById(skuLadder));
	}

	/**
	 * 新增或修改 商品阶梯价格
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入skuLadder")
	public R submit(@Valid @RequestBody SkuLadder skuLadder) {
		return R.status(skuLadderService.saveOrUpdate(skuLadder));
	}

	
	/**
	 * 删除 商品阶梯价格
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(skuLadderService.removeByIds(Func.toLongList(ids)));
	}

	
}
