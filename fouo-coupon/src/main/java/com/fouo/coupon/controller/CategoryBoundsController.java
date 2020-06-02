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
import com.fouo.coupon.entity.CategoryBounds;
import com.fouo.coupon.vo.CategoryBoundsVO;
import com.fouo.coupon.service.ICategoryBoundsService;

/**
 * 商品分类积分设置 控制器
 *
 * @author fouo
 * @since 2020-06-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/categorybounds")
@Api(value = "商品分类积分设置", tags = "商品分类积分设置接口")
public class CategoryBoundsController {

	private ICategoryBoundsService categoryBoundsService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入categoryBounds")
	public R<CategoryBounds> detail(CategoryBounds categoryBounds) {
		CategoryBounds detail = categoryBoundsService.getOne(Condition.getQueryWrapper(categoryBounds));
		return R.data(detail);
	}

	/**
	 * 分页 商品分类积分设置
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入categoryBounds")
	public R<IPage<CategoryBounds>> list(CategoryBounds categoryBounds, Query query) {
		IPage<CategoryBounds> pages = categoryBoundsService.page(Condition.getPage(query), Condition.getQueryWrapper(categoryBounds));
		return R.data(pages);
	}

	/**
	 * 自定义分页 商品分类积分设置
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入categoryBounds")
	public R<IPage<CategoryBoundsVO>> page(CategoryBoundsVO categoryBounds, Query query) {
		IPage<CategoryBoundsVO> pages = categoryBoundsService.selectCategoryBoundsPage(Condition.getPage(query), categoryBounds);
		return R.data(pages);
	}

	/**
	 * 新增 商品分类积分设置
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入categoryBounds")
	public R save(@Valid @RequestBody CategoryBounds categoryBounds) {
		return R.status(categoryBoundsService.save(categoryBounds));
	}

	/**
	 * 修改 商品分类积分设置
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入categoryBounds")
	public R update(@Valid @RequestBody CategoryBounds categoryBounds) {
		return R.status(categoryBoundsService.updateById(categoryBounds));
	}

	/**
	 * 新增或修改 商品分类积分设置
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入categoryBounds")
	public R submit(@Valid @RequestBody CategoryBounds categoryBounds) {
		return R.status(categoryBoundsService.saveOrUpdate(categoryBounds));
	}

	
	/**
	 * 删除 商品分类积分设置
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(categoryBoundsService.removeByIds(Func.toLongList(ids)));
	}

	
}
