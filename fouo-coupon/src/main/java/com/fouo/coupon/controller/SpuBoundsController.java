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
import com.fouo.coupon.entity.SpuBounds;
import com.fouo.coupon.vo.SpuBoundsVO;
import com.fouo.coupon.service.ISpuBoundsService;

/**
 * 商品spu积分设置 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/coupon/spubounds")
@Api(value = "商品spu积分设置", tags = "商品spu积分设置接口")
public class SpuBoundsController {

	private ISpuBoundsService spuBoundsService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入spuBounds")
	public R<SpuBounds> detail(SpuBounds spuBounds) {
		SpuBounds detail = spuBoundsService.getOne(Condition.getQueryWrapper(spuBounds));
		return R.data(detail);
	}

	/**
	 * 分页 商品spu积分设置
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入spuBounds")
	public R<IPage<SpuBounds>> list(SpuBounds spuBounds, Query query) {
		IPage<SpuBounds> pages = spuBoundsService.page(Condition.getPage(query), Condition.getQueryWrapper(spuBounds));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品spu积分设置
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入spuBounds")
	public R<IPage<SpuBoundsVO>> page(SpuBoundsVO spuBounds, Query query) {
		IPage<SpuBoundsVO> pages = spuBoundsService.selectSpuBoundsPage(Condition.getPage(query), spuBounds);
		return R.data(pages);
	}

	/**
	 * 新增 商品spu积分设置
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入spuBounds")
	public R saveSpuBounds(@Valid @RequestBody SpuBounds spuBounds) {
		return R.status(spuBoundsService.save(spuBounds));
	}

	/**
	 * 修改 商品spu积分设置
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入spuBounds")
	public R update(@Valid @RequestBody SpuBounds spuBounds) {
		return R.status(spuBoundsService.updateById(spuBounds));
	}

	/**
	 * 新增或修改 商品spu积分设置
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入spuBounds")
	public R submit(@Valid @RequestBody SpuBounds spuBounds) {
		return R.status(spuBoundsService.saveOrUpdate(spuBounds));
	}

	
	/**
	 * 删除 商品spu积分设置
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(spuBoundsService.removeByIds(Func.toLongList(ids)));
	}

	
}
